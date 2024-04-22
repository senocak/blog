package com.github.senocak.blog

import jakarta.persistence.*
import kotlin.random.Random
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationContext
import org.springframework.context.ApplicationContextAware
import org.springframework.stereotype.Service


@Entity
@Table(name = "roles")
@EntityListeners(Role.RoleListeners::class)
class Role: java.io.Serializable {
    @Id
    var id: Long? = null

    class RoleListeners {
        @PrePersist
        @PreUpdate
        fun prePersist(role: Role) {
            val snowflake: Snowflake = ContextWrapper.getBean("snowflake") as Snowflake
            val nextId: Long = snowflake.nextId
            println(message = "snowflake is not null and will be used: $nextId")
            role.id = nextId
        }
    }
}

@Service
class ContextWrapper: ApplicationContextAware {
    override fun setApplicationContext(appContext: ApplicationContext) = run { applicationContext = appContext }

    companion object {
        private var applicationContext: ApplicationContext? = null
        fun getBean(beanId: String?): Any? = applicationContext?.getBean(beanId!!)
    }
}

@Service
class Snowflake {
    @get:Synchronized
    val nextId: Long
        get() = Random.nextLong()

}

@Service
class RoleService(val applicationContext: ApplicationContext) {

}