package lvergergsk.example.spring.webflux.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class GreetingEntity(
    @Id @GeneratedValue
    @Column(name = "id")
    val greetingId: Long = 0,

    @Column(name = "message")
    val message: String = ""
)
