QueryDSL
---

### Init

```kotlin
plugins {
  // ...
  kotlin("kapt") version "1.0.22"
}

dependencies {
  // ...
  implementation("com.querydsl:querydsl-jpa:5.0.0:jakarta")
  kapt("com.querydsl:querydsl-apt:5.0.0:jakarta")
}
```

### JpaQueryFactory

```kotlin
@Configuration
class JpaQueryFactoryConfig {
  
  @PersistenceContext
  private lateinit var entityManager: EntityManager
  
  @Bean
  fun jpaQueryFactory() =
    JPAQueryFactory(entityManager)
}
```

### Entity

```kotlin
// model/UserEntity.kt

@Entity
class User(
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  val id: Long = 0,
  val name: String = "",
  val age: Int = 0,
)
```
### Repository

```kotlin
// repository/UserSupport.kt
interface UserSupport {
  fun findByName(name: String): List<UserDto>
}

// repository/UserSupportImpl.kt
class UserSupportImpl(
  private val queryFactory: JPAQueryFactory
) : UserSupport {
  override fun findByName(name: String): List<UserDto> {
    val user = QUser.user
    return queryFactory
      .select(
        Projections.constructor(
          UserDto::class.java,
          user.id,
          user.name,
          user.age
        )
      )
      .from(user)
      .where(user.name.eq(name))
      .fetch()
  }
}

// repository/UserRepository.kt
interface UserRepository : JpaRepository<User, Long>, UserSupport
```

### Environment Variables
- `DB_HOST`: Database endpoint (포트 제외)
- `DB_USERNAME`: Database username
- `DB_PASSWORD`: Database password
- `SHOW_SQL`: Runtime SQL 출력 여부
- `FORMAT_SQL`: Runtime SQL 포맷팅 여부
