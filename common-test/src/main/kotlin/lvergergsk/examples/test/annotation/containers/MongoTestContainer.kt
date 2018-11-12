package lvergergsk.examples.test.annotation.containers

import lvergergsk.examples.test.annotation.config.MongoTestContainerProperty
import org.springframework.boot.test.util.TestPropertyValues
import org.springframework.context.ApplicationContextInitializer
import org.springframework.context.ConfigurableApplicationContext
import org.testcontainers.containers.DockerComposeContainer
import org.testcontainers.containers.wait.strategy.Wait
import java.io.File
import java.nio.file.Paths

//2018-11-09 19:14:13.188  INFO 67529 --- [iners-netty-1-6] o.t.containers.DockerComposeContainer    : [/4khqbm4so49x_mysql_1] STDERR: 2018-11-09T10:14:13.194645Z 0 [Note] mysqld: ready for connections.
//2018-11-09 19:16:04.829  INFO 67815 --- [iners-netty-1-3] o.t.containers.DockerComposeContainer    : [/nbnxx8ptbyyd_mongo_1] STDOUT: 2018-11-09T10:16:04.832+0000 I NETWORK  [initandlisten] waiting for connections on port 27017
@Suppress("unused")
object MongoTestContainer {
    private lateinit var properties: MongoTestContainerProperty
    private val container: KDockerComposeContainer by lazy {
        KDockerComposeContainer(Paths.get(properties.dockerComposeFile).toAbsolutePath().normalize().toFile())
            .withExposedService(
                properties.serviceName,
                properties.port,
                Wait.forLogMessage(".*waiting for connections.*\\n", 2)
            )
            .withTailChildContainers(true)
    }

    class Initializer : ApplicationContextInitializer<ConfigurableApplicationContext> {
        override fun initialize(applicationContext: ConfigurableApplicationContext) {
            try {
                properties = MongoTestContainerProperty.fromEnvironment(applicationContext.environment)
                container.starting(null)

                TestPropertyValues.of(
                    "spring.data.mongo.host=${container.getServiceHost(
                        properties.serviceName,
                        properties.port
                    )}",
                    "spring.data.mongo.port=${container.getServicePort(
                        properties.serviceName,
                        properties.port
                    )}"
                ).applyTo(applicationContext)

                Runtime.getRuntime().addShutdownHook(Thread {
                    container.finished(null)
                })
            } catch (e: Exception) {
                container.finished(null)
                throw IllegalStateException("Docker initialization failed", e)
            }
        }
    }

    private class KDockerComposeContainer(file: File) : DockerComposeContainer<KDockerComposeContainer>(file)
}
