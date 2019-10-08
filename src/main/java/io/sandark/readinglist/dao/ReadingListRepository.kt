package io.sandark.readinglist.dao

import io.sandark.readinglist.entity.Book
import io.sandark.readinglist.entity.User
import org.springframework.data.jpa.repository.JpaRepository

interface ReadingListRepository : JpaRepository<Book, Long> {

    fun findByReader(reader: User) : List<Book>?

}