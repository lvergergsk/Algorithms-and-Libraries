package lvergergsk.example.spring.webflux.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "greeting")
data class GreetingEntity(

    /**
     * You can't change name of id, there must be a property named "id" in entity.
     */
    @Id @GeneratedValue
    @Column(name = "greeting_id")
    val id: Long = 0,

    @Column(name = "message")
    val message: String = ""
)
