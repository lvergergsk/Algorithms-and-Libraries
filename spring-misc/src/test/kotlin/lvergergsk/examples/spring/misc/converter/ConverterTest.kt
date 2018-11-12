package lvergergsk.examples.spring.misc.converter

import lvergergsk.examples.spring.misc.dto.UserDto
import lvergergsk.examples.spring.misc.entity.UserEntity
import lvergergsk.examples.test.helper.SpringApplicationTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.convert.ConversionService

class ConverterTest : SpringApplicationTest() {

    @Autowired
    private lateinit var conversionService: ConversionService

    @Test
    fun testConverter() {
        val userEntity = UserEntity(0, "Michael", "Zhang", "boss")
        val userDto = UserDto("Michael", "Zhang", "boss")
        val convertedUserDto = conversionService.convert(userEntity, UserDto::class.java)
        Assertions.assertEquals(userDto, convertedUserDto)
    }

}
