package querydsl.repository

import querydsl.entity.User

interface UserSupport {
  fun findByName(name: String): List<User>
}
