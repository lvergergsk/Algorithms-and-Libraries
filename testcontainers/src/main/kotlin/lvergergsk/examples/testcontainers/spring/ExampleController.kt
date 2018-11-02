package lvergergsk.examples.testcontainers.spring

import org.springframework.data.redis.core.StringRedisTemplate
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class DemoController(private val stringRedisTemplate: StringRedisTemplate) {

    @GetMapping("/foo")
    fun get(): String? {
        return stringRedisTemplate.opsForValue().get("foo")
    }

    @PutMapping("/foo")
    fun set(@RequestBody value: String) {
        stringRedisTemplate.opsForValue().set("foo", value)
    }
}
