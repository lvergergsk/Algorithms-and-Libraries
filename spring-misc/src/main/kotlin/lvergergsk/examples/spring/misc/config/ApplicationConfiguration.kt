package lvergergsk.examples.spring.misc.config

import lvergergsk.examples.spring.misc.converter.UserEntityToUserDtoConverter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.convert.ConversionService
import org.springframework.core.convert.support.DefaultConversionService

@Configuration
class ApplicationConfiguration {
    @Bean
    fun conversionService(): ConversionService {
        val defaultConversionService = DefaultConversionService()
        defaultConversionService.addConverter(UserEntityToUserDtoConverter())
        return defaultConversionService
    }
}
