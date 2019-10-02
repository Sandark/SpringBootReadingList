package io.sandark.readinglist.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Book(
        @Id @GeneratedValue(strategy = GenerationType.AUTO) var id:Long = 0,
        var title: String? = null,
        var author: String? = null,
        var isbn: String? = null,
        var description: String? = null,
        var reader: String? = null
        )

