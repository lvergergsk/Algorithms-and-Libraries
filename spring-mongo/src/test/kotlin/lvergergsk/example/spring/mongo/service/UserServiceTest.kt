package lvergergsk.example.spring.mongo.service

import lvergergsk.examples.test.annotation.WithContainers
import lvergergsk.examples.test.annotation.containers.MongoTestContainer
import lvergergsk.examples.test.helper.SpringApplicationTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired

@WithContainers(initializers = [MongoTestContainer.Initializer::class])
class UserServiceTest : SpringApplicationTest() {
    private val log = LoggerFactory.getLogger(javaClass)

    @Autowired
    private lateinit var userService: UserService

    @Test
    fun createDeployment() {
        val userEntity = userService.findByFirstName("Michael")
        log.debug("UserEntity: $userEntity")

        Assertions.assertEquals("Michael", userEntity.firstName)
        Assertions.assertEquals("Zhang", userEntity.lastName)
    }

}

