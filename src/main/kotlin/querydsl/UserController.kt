package querydsl

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import querydsl.model.UserDto
import querydsl.repository.UserJpaRepository
import querydsl.model.UserMapper

@RestController
class UserController{
  @Autowired
  lateinit var userJpaRepository: UserJpaRepository
  @GetMapping("/users/{name}")
  fun findByName(
    @PathVariable name: String = "dave",
  ) = userJpaRepository.findByName(name)

  @PostMapping("/users")
  fun create(
    @RequestBody user: UserDto,
  ) = userJpaRepository.save(UserMapper.toEntity(user))
}
