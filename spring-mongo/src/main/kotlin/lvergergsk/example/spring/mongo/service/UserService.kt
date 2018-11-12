package lvergergsk.example.spring.mongo.service

import lvergergsk.example.spring.mongo.entity.User
import lvergergsk.example.spring.mongo.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository
) {
    fun findByFirstName(firstName: String): User {
        return userRepository.findByFirstName(firstName)
    }
}
