package lvergergsk.examples.testcontainers.spring

import junit.framework.Assert.assertEquals
import lvergergsk.examples.testcontainers.Utils
import org.junit.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.web.client.TestRestTemplate


class DemoControllerTest : AbstractIntegrationTest() {

    companion object {
        private val log = Utils.loggerFor(javaClass)
    }

    @Autowired
    internal var restTemplate: TestRestTemplate? = null

    @Test
    fun simpleTest() {
        val fooResource = "/foo"

        log.info("putting 'bar' to $fooResource")
        restTemplate!!.put(fooResource, "bar")

        assertEquals("value is set", "bar", restTemplate!!.getForObject(fooResource, String::class.java))
    }

}
