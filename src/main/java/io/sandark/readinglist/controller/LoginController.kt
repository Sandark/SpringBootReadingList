package io.sandark.readinglist.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class LoginController {

    @RequestMapping("/")
    fun loginPage(): String {

        return "loginPage";
    }
}