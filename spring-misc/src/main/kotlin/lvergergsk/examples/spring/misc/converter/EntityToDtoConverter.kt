package lvergergsk.examples.spring.misc.converter

import lvergergsk.examples.spring.misc.dto.UserDto
import lvergergsk.examples.spring.misc.entity.UserEntity
import org.springframework.core.convert.converter.Converter

class UserEntityToUserDtoConverter : Converter<UserEntity, UserDto> {
    override fun convert(source: UserEntity): UserDto? {
        return UserDto(
            source.firstName,
            source.lastName,
            source.role
        )
    }
}
