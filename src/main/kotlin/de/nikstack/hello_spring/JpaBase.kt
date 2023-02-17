package de.nikstack.hello_spring

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.domain.AuditorAware
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import org.springframework.data.repository.NoRepositoryBean
import org.springframework.security.core.context.SecurityContextHolder
import java.util.*

@NoRepositoryBean
interface EntityRepo<E> : JpaRepository<E, UUID>


@Configuration
@EnableJpaAuditing
class JpaAuditingConfiguration {
    @Bean
    fun auditorProvider() = AuditorAware {
        Optional.of(SecurityContextHolder.getContext().authentication.name)
    }
}
