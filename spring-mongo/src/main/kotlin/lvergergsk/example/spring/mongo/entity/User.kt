package lvergergsk.example.spring.mongo.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

@Document
data class User(
    @Id
    val id: String,

    @Field("firstname")
    val firstName: String,
    @Field("lastname")
    val lastName: String,
    @Field("tag")
    val tag: List<String>
)
