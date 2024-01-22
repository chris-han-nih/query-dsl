package querydsl.repository

import com.querydsl.core.types.Projections
import com.querydsl.jpa.impl.JPAQueryFactory
import jakarta.persistence.EntityManager
import jakarta.persistence.PersistenceContext
import org.springframework.stereotype.Component
import querydsl.entity.QUser

@Component
class UserSupportImpl (
  @PersistenceContext
  private val entityManager: EntityManager
): UserSupport {
  override fun findByName(name: String): List<UserDto> {
    val queryFactory = JPAQueryFactory(entityManager)
    val user = QUser.user
    return queryFactory
      .select(
        Projections.constructor(
          UserDto::class.java,
          user.name,
          user.age,
          user.email
        )
      )
      .from(user)
      .where(user.name.contains(name))
      .fetch()
  }
}
