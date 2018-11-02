package lvergergsk.examples.testcontainers

import org.slf4j.LoggerFactory

object Utils {
    fun <T> loggerFor(clazz: Class<T>) = LoggerFactory.getLogger(clazz)
}
