package lvergergsk.examples.testcontainers.spring

import org.junit.ClassRule
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.util.TestPropertyValues
import org.springframework.context.ApplicationContextInitializer
import org.springframework.context.ConfigurableApplicationContext
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.testcontainers.containers.GenericContainer


@RunWith(SpringJUnit4ClassRunner::class)
@SpringBootTest(classes = [ExampleApplication::class], webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration(initializers = [AbstractIntegrationTest.Initializer::class])
class AbstractIntegrationTest {

    companion object {
        @ClassRule
        @JvmField
        val redis = KGenericContainer("redis:3.0.6").withExposedPorts(6379)
    }

    class Initializer : ApplicationContextInitializer<ConfigurableApplicationContext> {

        override fun initialize(configurableApplicationContext: ConfigurableApplicationContext) {
            val values = TestPropertyValues.of(
                    "spring.redis.host=" + redis.containerIpAddress,
                    "spring.redis.port=" + redis.getMappedPort(6379)
            )
            values.applyTo(configurableApplicationContext)
        }
    }

    class KGenericContainer(imageName: String) : GenericContainer<KGenericContainer>(imageName)
}
