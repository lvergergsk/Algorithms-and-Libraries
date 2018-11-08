package lvergergsk.example.mybatis.service

import lvergergsk.example.mybatis.entity.GreetingEntity
import lvergergsk.example.mybatis.mapper.GreetingMapper
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class GreetingService(private val greetingMapper: GreetingMapper) {
    @Transactional
    fun insert(greetingEntity: GreetingEntity) {
        greetingMapper.insert(greetingEntity)
    }

    @Transactional
    fun findById(id: Long): GreetingEntity {
        return greetingMapper.findById(id)
    }
}
