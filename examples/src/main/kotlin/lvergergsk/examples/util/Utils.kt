package lvergergsk.examples.util

import org.slf4j.LoggerFactory

object Utils {
    fun <T> loggerFor(clazz: Class<T>) = LoggerFactory.getLogger(clazz)
}
