package querydsl.repository

interface UserSupport {
  fun findByName(name: String): List<UserDto>
}
