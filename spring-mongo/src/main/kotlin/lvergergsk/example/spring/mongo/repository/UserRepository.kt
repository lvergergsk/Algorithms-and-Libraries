package lvergergsk.example.spring.mongo.repository

import lvergergsk.example.spring.mongo.entity.User
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : MongoRepository<User, String> {
    fun findByFirstName(firstName: String): User
    fun findByLastName(lastName: String): List<User>
}
