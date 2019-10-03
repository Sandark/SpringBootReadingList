package io.sandark.readinglist.dao

import io.sandark.readinglist.dto.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long>  {
}