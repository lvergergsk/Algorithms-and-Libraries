package lvergergsk.example.spring.mongo.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Field

data class User(
    @Id
    var id: String,

    @Field("firstname")
    var firstName: String,
    @Field("lastname")
    var lastName: String
)
