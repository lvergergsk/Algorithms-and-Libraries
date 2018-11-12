package lvergergsk.example.spring.mybatis.service

import lvergergsk.example.spring.mybatis.entity.GreetingEntity
import lvergergsk.examples.test.annotation.WithContainers
import lvergergsk.examples.test.annotation.containers.MysqlTestContainer
import lvergergsk.examples.test.helper.SpringApplicationTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired

@WithContainers(initializers = [MysqlTestContainer.Initializer::class])
class GreetingServiceTest : SpringApplicationTest() {
    val log: Logger = LoggerFactory.getLogger(javaClass)

    @Autowired
    private lateinit var greetingService: GreetingService

    /**
     * Id 1 is inserted into DB when init
     */
    @DisplayName("MyBatis: Retrieve data using sql provider.")
    @Test
    fun `Retrive data`() {
        val greetingEntity = greetingService.findById(1)
        log.debug("Retrieved greetingEntity: $greetingEntity")

        // Assertions:
        Assertions.assertEquals(1, greetingEntity.id)
        Assertions.assertEquals("Hello.", greetingEntity.message)
    }

    @DisplayName("MyBatis: Insert new data using sql provider.")
    @Test
    fun `Insert new data`() {
        // Auto increment id is ignored.
        val greetingEntity2 = GreetingEntity(0, "Second greeting")
        val greetingEntity3 = GreetingEntity(0, "Third greeting")
        greetingService.insert(greetingEntity2)
        greetingService.insert(greetingEntity3)

        // Assertions:
        Assertions.assertEquals(GreetingEntity(2, "Second greeting"), greetingService.findById(2))
        Assertions.assertEquals(GreetingEntity(3, "Third greeting"), greetingService.findById(3))
    }
}

