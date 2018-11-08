package lvergergsk.example.spring.webflux.repository

import lvergergsk.example.spring.webflux.entity.GreetingEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface GreetingRepository : JpaRepository<GreetingEntity, Long>
