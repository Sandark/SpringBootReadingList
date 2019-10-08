package io.sandark.readinglist.dto

import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

data class UserDto(
        @NotNull @NotEmpty var username: String? = null,
        @NotNull @NotEmpty var password: String? = null,
        var matchingPassword: String? = null,
        @NotNull @NotEmpty @Email var email: String?  = null
)