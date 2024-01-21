package querydsl.repository

import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Component
import querydsl.entity.QUser
import querydsl.entity.User

@Component
class UserSupportImpl (
  private val queryFactory: JPAQueryFactory
): UserSupport{
  override fun findByName(name: String): List<User> {
    return queryFactory
      .select(QUser.user)
      .from(QUser.user)
      .where(QUser.user.name.eq(name))
      .fetch()
  }
}
