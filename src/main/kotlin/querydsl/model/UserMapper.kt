package querydsl.model

class UserMapper {
  companion object {
    fun toEntity(userDto: UserDto) = UserEntity(
      name = userDto.name,
      age = userDto.age,
      email = userDto.email
    )
    fun toDto(user: UserEntity) = UserDto(
      name = user.name!!,
      age = user.age!!,
      email = user.email!!
    )
  }
}