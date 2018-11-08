package lvergergsk.examples.kotlin.official

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class ClassAndObjects {

    // Delegated Properties
    /**
     * <p> Delegation, ``Lazy``.
     */
    @Test
    fun lazy() {
        var evaluated = false
        val lazy: Int by lazy {
            evaluated = true
            0
        }
        Assertions.assertFalse(evaluated)
        Assertions.assertEquals(0, lazy)
        Assertions.assertTrue(evaluated)
    }

    // TODO: Observable
    // TODO: Map
    // TODO: Vetoable
    // TODO: NotNull
}
