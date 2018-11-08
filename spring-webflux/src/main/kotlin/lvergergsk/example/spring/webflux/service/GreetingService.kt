package lvergergsk.example.spring.webflux.service

import lvergergsk.example.common.utils.toNullable
import lvergergsk.example.spring.webflux.entity.GreetingEntity
import lvergergsk.example.spring.webflux.exception.NotFoundException
import lvergergsk.example.spring.webflux.repository.GreetingRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class GreetingService(
    private val greetingRepository: GreetingRepository
) {
    @Transactional(readOnly = true)
    fun findGreetingById(id: Long): GreetingEntity {
        return greetingRepository.findById(id).toNullable()
                ?: throw  NotFoundException("Greeting with id $id not found.")
    }
}
