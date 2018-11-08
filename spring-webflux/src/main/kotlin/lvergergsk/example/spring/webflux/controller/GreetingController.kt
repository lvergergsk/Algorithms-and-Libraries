package lvergergsk.example.spring.webflux.controller

import lvergergsk.example.spring.webflux.response.GreetingResponse
import lvergergsk.example.spring.webflux.service.GreetingService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/greeting")
class GreetingController(
    private val greetingService: GreetingService
) {
    /**
     * only allow 1 for Id initially.
     */
    @GetMapping("/{id}")
    fun getGreetingMessage(@PathVariable id: Long): Mono<GreetingResponse> {
        val greetingEntityMono = greetingService.findGreetingById(id)

        // Receive a mono, manipulate and return Mono response.
        return greetingEntityMono.map { greetingEntity ->
            GreetingResponse(
                greetingEntity.greetingId,
                greetingEntity.message
            )
        }
    }

}
