package lvergergsk.example.spring.mybatis.provider

import lvergergsk.example.spring.mybatis.entity.GreetingEntity
import org.apache.ibatis.annotations.Param
import org.apache.ibatis.jdbc.SQL

@Suppress("unused")
class GreetingSqlProvider {
    companion object {
        @JvmStatic
        fun findById(@Param("id") id: Long): String {
            return object : SQL() {
                init {
                    SELECT("greeting_id,message")
                    FROM("greeting")
                    WHERE("greeting_id=#{id}")
                }
            }.toString()
        }

        @JvmStatic
        fun insert(
            @Suppress("UNUSED_PARAMETER")
            greetingEntity: GreetingEntity
        ): String {
            return object : SQL() {
                init {
                    INSERT_INTO("greeting")
                    VALUES("greeting_id", "#{id}")
                    VALUES("message", "#{message}")
                }
            }.toString()
        }
    }
}
