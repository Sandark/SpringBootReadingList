package io.sandark.readinglist.controller

import io.sandark.readinglist.dao.UserRepository
import io.sandark.readinglist.dto.UserDto
import io.sandark.readinglist.entity.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.validation.Errors
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.ModelAndView
import javax.validation.Valid

@Controller
class LoginAndRegistrationController @Autowired constructor(val userRepository: UserRepository,
                                                            val passwordEncoder: PasswordEncoder) {

    @RequestMapping("/register", method = [RequestMethod.GET])
    fun showRegistration(request: WebRequest, model: Model): String {
        val userDto: UserDto = UserDto()
        model.addAttribute("user", userDto)

        return "registrationForm";
    }

    @RequestMapping("/login", method = [RequestMethod.GET])
    fun showLogin(request: WebRequest, model: Model): String {
        val userDto: UserDto = UserDto()
        model.addAttribute("user", userDto)

        return "loginForm";
    }

    @RequestMapping("/register", method = [RequestMethod.POST])
    fun register(@ModelAttribute("user") @Valid userDto: UserDto,
                 result: BindingResult, request: WebRequest, errors: Errors): ModelAndView {

        var registered: User? = User()

        if (!result.hasErrors()) {
            registered = createUserAccount(userDto, result)
        }

        if (registered == null) {
            result.rejectValue("email", "message.regError")
        }

        return ModelAndView()
    }

    private fun createUserAccount(userDto: UserDto, result: BindingResult): User? {
        var user: User = User()

        user.username = userDto.username
        user.email = userDto.email
        user.password = passwordEncoder.encode(userDto.password)

        userRepository.save(user)

        return user
    }
}