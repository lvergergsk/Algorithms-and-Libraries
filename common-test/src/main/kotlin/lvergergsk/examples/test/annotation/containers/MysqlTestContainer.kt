package lvergergsk.examples.test.annotation.containers

import lvergergsk.examples.test.annotation.config.MysqlTestContainerProperty
import org.springframework.boot.test.util.TestPropertyValues
import org.springframework.context.ApplicationContextInitializer
import org.springframework.context.ConfigurableApplicationContext
import org.testcontainers.containers.DockerComposeContainer
import org.testcontainers.containers.wait.strategy.Wait
import java.io.File
import java.nio.file.Paths

@Suppress("unused")
object MysqlTestContainer {
    private lateinit var properties: MysqlTestContainerProperty
    private val container: KDockerComposeContainer by lazy {
        KDockerComposeContainer(Paths.get(properties.dockerComposeFile).toAbsolutePath().normalize().toFile())
            .withExposedService(
                properties.serviceName,
                properties.port,
                Wait.forLogMessage(".*ready for connections.*\\s", 2)
            )
            .withTailChildContainers(true)
    }

    fun getJdbcUrl() = "jdbc:mysql://${container.getServiceHost(
        properties.serviceName, properties.port
    )}:${container.getServicePort(
        properties.serviceName, properties.port
    )}/${properties.name}"

    class Initializer : ApplicationContextInitializer<ConfigurableApplicationContext> {
        override fun initialize(applicationContext: ConfigurableApplicationContext) {
            try {
                properties = MysqlTestContainerProperty.fromEnvironment(applicationContext.environment)
                container.starting(null)

                TestPropertyValues.of(
                    "spring.datasource.url=${getJdbcUrl()}"
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
