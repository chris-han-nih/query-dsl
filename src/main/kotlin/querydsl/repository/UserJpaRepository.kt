package querydsl.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import querydsl.entity.User

@Repository
interface UserJpaRepository: JpaRepository<User, Long>, UserSupport
