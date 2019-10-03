package io.sandark.readinglist.dao

import io.sandark.readinglist.entity.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long>  {

    fun findUserByUsername(username: String): User
}