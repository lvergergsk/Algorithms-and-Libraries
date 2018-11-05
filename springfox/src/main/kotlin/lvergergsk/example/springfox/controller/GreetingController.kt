package lvergergsk.example.springfox.controller

import lvergergsk.example.springfox.response.HelloResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class GreetingController {
    @GetMapping("/api/greeting/hello")
    fun hello(): HelloResponse {
        return HelloResponse("Hello.")
    }
}
