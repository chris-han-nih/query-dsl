package querydsl.repository

import querydsl.entity.User

class UserMapper {
  companion object {
    fun toEntity(userDto: UserDto) = User(
      name = userDto.name,
      age = userDto.age,
      email = userDto.email
    )
    fun toDto(user: User) = UserDto(
      name = user.name!!,
      age = user.age!!,
      email = user.email!!
    )
  }
}