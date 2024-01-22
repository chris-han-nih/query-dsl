package querydsl.repository

import querydsl.model.UserDto

interface UserSupport {
  fun findByName(name: String): List<UserDto>
}
