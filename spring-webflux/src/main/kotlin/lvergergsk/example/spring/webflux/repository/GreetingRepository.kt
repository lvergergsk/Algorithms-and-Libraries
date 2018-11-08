package lvergergsk.example.spring.webflux.repository

import lvergergsk.example.spring.webflux.entity.GreetingEntity
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository

/**
 * ReactiveCrudRepository will return publisher types.
 */
@Repository
interface GreetingRepository : ReactiveCrudRepository<GreetingEntity, Long>
