package lvergergsk.examples.test.annotation.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.core.env.Environment

@Suppress("unused")
@ConfigurationProperties(prefix = "test.container.mysql")
data class MysqlTestContainerProperty(
    var dockerComposeFile: String = "../container/docker-compose.mysql.yml",
    var name: String = "example",
    var port: Int = 3306,
    var serviceName: String = "mysql"
) {
    companion object {
        fun fromEnvironment(env: Environment) = MysqlTestContainerProperty().apply {
            dockerComposeFile =
                    env.getProperty(
                        "test.container.mysql.docker-compose-file",
                        "../container/docker-compose.mysql.yml"
                    )
            name = env.getProperty("test.container.mysql.name", "example")
            port = env.getProperty("test.container.mysql.port", "3306").toInt()
            serviceName = env.getProperty("test.container.mysql.serviceName", "mysql")
        }
    }
}
