package querydsl.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import querydsl.model.UserEntity

@Repository
interface UserJpaRepository: JpaRepository<UserEntity, Long>, UserSupport
