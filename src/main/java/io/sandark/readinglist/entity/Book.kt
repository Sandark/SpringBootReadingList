package io.sandark.readinglist.entity

import io.sandark.readinglist.dto.User
import javax.persistence.*

@Entity
data class Book(
        @Id @GeneratedValue(strategy = GenerationType.AUTO) var id:Long = 0,
        var title: String? = null,
        var author: String? = null,
        var isbn: String? = null,
        var description: String? = null,
        @ManyToOne var reader: User? = null
        )

