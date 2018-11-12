package lvergergsk.examples.test.annotation.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.core.env.Environment

@Suppress("unused")
@ConfigurationProperties(prefix = "test.container.mongo")
class MongoTestContainerProperty(
    var dockerComposeFile: String = "../container/docker-compose.mongo.yml",
    var port: Int = 27017,
    var serviceName: String = "mongo"
) {
    companion object {
        fun fromEnvironment(env: Environment) = MongoTestContainerProperty().apply {
            dockerComposeFile =
                    env.getProperty(
                        "test.container.mongo.docker-compose-file",
                        "../container/docker-compose.mongo.yml"
                    )
            port = env.getProperty("test.container.mongo.port", "27017").toInt()
            serviceName = env.getProperty("test.container.mongo.serviceName", "mongo")
        }
    }
}
