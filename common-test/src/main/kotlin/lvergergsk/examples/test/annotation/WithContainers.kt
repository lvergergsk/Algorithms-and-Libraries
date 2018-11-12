package lvergergsk.examples.test.annotation

import org.springframework.context.ApplicationContextInitializer
import org.springframework.core.annotation.AliasFor
import org.springframework.test.context.ContextConfiguration
import java.lang.annotation.Inherited
import kotlin.reflect.KClass

@Suppress("unused")
@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@Inherited
@ContextConfiguration
annotation class WithContainers(
    @get:AliasFor(annotation = ContextConfiguration::class, attribute = "initializers")
    @Suppress("unused")
    val initializers: Array<KClass<out ApplicationContextInitializer<*>>> = []
)
