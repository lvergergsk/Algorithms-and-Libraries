package lvergergsk.example.mybatis.mapper

import lvergergsk.example.mybatis.entity.GreetingEntity
import lvergergsk.example.mybatis.provider.GreetingSqlProvider
import org.apache.ibatis.annotations.InsertProvider
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Param
import org.apache.ibatis.annotations.SelectProvider
import org.springframework.stereotype.Repository

@Mapper
@Repository
interface GreetingMapper {
    @SelectProvider(type = GreetingSqlProvider::class, method = "findById")
    fun findById(@Param("id") id: Long): GreetingEntity

    @InsertProvider(type = GreetingSqlProvider::class, method = "insert")
    fun insert(greetingEntity: GreetingEntity)
}
