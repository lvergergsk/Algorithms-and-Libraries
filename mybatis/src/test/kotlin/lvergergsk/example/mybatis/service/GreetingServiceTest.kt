package lvergergsk.example.mybatis.service

import lvergergsk.example.mybatis.entity.GreetingEntity
import lvergergsk.examples.test.annotation.SpringTestHelper
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired

@SpringTestHelper
class GreetingServiceTest {
    companion object {
        val log = LoggerFactory.getLogger(javaClass)
    }

    @Autowired
    lateinit var greetingService: GreetingService

    /**
     * Id 1 is inserted into DB when init
     */
    @DisplayName("MyBatis: retrive data using sql provider.")
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

