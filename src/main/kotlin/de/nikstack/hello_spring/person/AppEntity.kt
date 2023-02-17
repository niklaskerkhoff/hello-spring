package de.nikstack.hello_spring.person

import jakarta.persistence.*
import org.springframework.data.annotation.CreatedBy
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedBy
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime
import java.util.*

@Entity
@EntityListeners(AuditingEntityListener::class)
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
abstract class AppEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID? = null

    @CreatedDate
    var createdDate: LocalDateTime? = null
        private set

    @LastModifiedDate
    var lastModifiedDate: LocalDateTime? = null
        private set

    @CreatedBy
    var createdBy: String? = null
        private set

    @LastModifiedBy
    var lastModifiedBy: String? = null
        private set
}
