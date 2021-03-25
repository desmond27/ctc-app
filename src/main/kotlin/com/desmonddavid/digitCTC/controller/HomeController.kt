package com.desmonddavid.digitCTC.controller

import org.springframework.security.core.Authentication
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/")
class HomeController {

    @GetMapping
    fun onLogin(authentication: Authentication?, model: Model): String {
        val roles = authentication?.authorities.toString()
        model.addAttribute("auth", authentication)
        return if(roles.contains("ADMIN") || roles.contains("ROOT"))
            "redirect:/admin"
        else
            "index"
    }

}

@Controller
@RequestMapping("/admin")
class AdminController {

    @GetMapping
    fun loadAdminPage(authentication: Authentication?): String {
        return "admin"
    }
}

