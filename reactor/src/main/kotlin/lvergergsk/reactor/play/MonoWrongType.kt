package lvergergsk.reactor.play

import reactor.core.publisher.Mono

class MonoWrongType {
    data class ExpectedStructure(
        val id: Int,
        val message: String
    )

    data class WrongStructure(
        val something: String
    )

//    fun returnWrongType(): Mono<ExpectedStructure> {
//        return Mono.just(WrongStructure("bad"))
//    }
}
