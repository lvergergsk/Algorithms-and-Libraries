package lvergergsk.example.spring.webflux.service

import lvergergsk.example.spring.webflux.entity.GreetingEntity
import lvergergsk.example.spring.webflux.repository.GreetingRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import reactor.core.publisher.Mono

@Service
class GreetingService(
    private val greetingRepository: GreetingRepository
) {
    @Transactional(readOnly = true)
    fun findGreetingById(id: Long): Mono<GreetingEntity> {
        return greetingRepository.findById(id)
    }
}
