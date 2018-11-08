package lvergergsk.example.mybatis.provider

import lvergergsk.example.mybatis.entity.GreetingEntity
import org.apache.ibatis.annotations.Param
import org.apache.ibatis.jdbc.SQL

@Suppress("unused")
class GreetingSqlProvider {
    companion object {
        @JvmStatic
        fun findById(@Param("id") id: Long): String {
            return object : SQL() {
                init {
                    SELECT("id,message")
                    FROM("greeting")
                    WHERE("id=#{id}")
                }
            }.toString()
        }

        @JvmStatic
        fun insert(greetingEntity: GreetingEntity): String {
            return object : SQL() {
                init {
                    INSERT_INTO("greeting")
                    VALUES("id", "#{id}")
                    VALUES("message", "#{message}")
                }
            }.toString()
        }
    }
}
