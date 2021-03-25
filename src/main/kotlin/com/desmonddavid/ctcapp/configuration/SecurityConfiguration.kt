package com.desmonddavid.ctcapp.configuration

import com.desmonddavid.ctcapp.services.CtcUserService
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder

@EnableWebSecurity
class SecurityConfiguration(val ctcUserService: CtcUserService) : WebSecurityConfigurerAdapter() {

    override fun configure(auth: AuthenticationManagerBuilder) {
        auth.userDetailsService(ctcUserService).passwordEncoder(passwordEncoder())
    }

    override fun configure(http: HttpSecurity) {
        http.authorizeRequests()
            .antMatchers("/greetings").permitAll()
            .antMatchers("/").authenticated()
            .and()
            .formLogin()
            .and()
            .logout().permitAll()
    }

    fun passwordEncoder() : PasswordEncoder {
        return BCryptPasswordEncoder()
    }
}