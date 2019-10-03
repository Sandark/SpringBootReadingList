package io.sandark.readinglist.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

@Entity
data class User(
        @Id @GeneratedValue() var id: Long? = 0,
        @NotNull @NotEmpty var username: String? = null,
        @NotNull @NotEmpty var lastName: String? = null,
        @NotNull @NotEmpty var password: String? = null,
        var matchingPassword: String? = null,
        @NotNull @NotEmpty @Email var email: String?  = null
) {
}