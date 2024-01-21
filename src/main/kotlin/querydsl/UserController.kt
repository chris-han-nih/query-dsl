package querydsl

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import querydsl.repository.UserJpaRepository

@RestController
class UserController{
  @Autowired
  lateinit var userJpaRepository: UserJpaRepository
  @GetMapping("/users")
  fun findByName(name: String = "dave") = userJpaRepository.findByName(name)
}
