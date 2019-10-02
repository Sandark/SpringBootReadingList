package io.sandark.readinglist.dao

import io.sandark.readinglist.entity.Book
import org.springframework.data.jpa.repository.JpaRepository

interface ReadingListRepository : JpaRepository<Book, Long> {

    fun findByReader(reader: String) : List<Book>?

}