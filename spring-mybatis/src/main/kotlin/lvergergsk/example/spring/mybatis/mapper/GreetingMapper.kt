package lvergergsk.example.spring.mybatis.mapper

import lvergergsk.example.spring.mybatis.entity.GreetingEntity
import lvergergsk.example.spring.mybatis.provider.GreetingSqlProvider
import org.apache.ibatis.annotations.InsertProvider
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Param
import org.apache.ibatis.annotations.Result
import org.apache.ibatis.annotations.Results
import org.apache.ibatis.annotations.SelectProvider
import org.springframework.stereotype.Repository

@Mapper
@Repository
interface GreetingMapper {
    @SelectProvider(type = GreetingSqlProvider::class, method = "findById")
    @Results(Result(property = "id", column = "greeting_id"))
    fun findById(@Param("id") id: Long): GreetingEntity

    @InsertProvider(type = GreetingSqlProvider::class, method = "insert")
    @Results(Result(property = "id", column = "greeting_id"))
    fun insert(greetingEntity: GreetingEntity)
}
