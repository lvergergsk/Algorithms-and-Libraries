@file:Suppress("unused")

package lvergergsk.example.common.utils

import java.util.Optional

fun <T : Any> Optional<T>.toNullable(): T? = this.orElse(null)
