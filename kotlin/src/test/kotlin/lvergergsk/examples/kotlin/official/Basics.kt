package lvergergsk.examples.kotlin.official

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Basics {

    /**
     * <p> Double 64
     * <p> Float 32
     * <p> Long 64
     * <p> Int 32
     * <p> Short 16
     * <p> Byte 8
     */
    fun numberTypes() {
    }

    @Suppress("USELESS_IS_CHECK")
    @Test
    fun literalConstants() {
        Assertions.assertTrue(123L is Long)
        Assertions.assertTrue(0x0F is Int)
    }
}
