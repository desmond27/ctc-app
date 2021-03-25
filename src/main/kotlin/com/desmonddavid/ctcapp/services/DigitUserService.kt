package com.desmonddavid.ctcapp.services

import com.desmonddavid.ctcapp.entities.DigitUser
import com.desmonddavid.ctcapp.entities.DigitUserRole
import com.desmonddavid.ctcapp.repositories.DigitUserRepository
import org.slf4j.LoggerFactory
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.ArrayList

@Service
class DigitUserService(private val digitUserRepository: DigitUserRepository) : UserDetailsService {

    private val logger = LoggerFactory.getLogger(DigitUserService::class.java)

    @Transactional(readOnly = true)
    override fun loadUserByUsername(username: String?): UserDetails {
        logger.debug("Fetching user details for user: $username")
        val digitUser: DigitUser = digitUserRepository.findByUsername(username!!)
        logger.debug("Found username: " + digitUser.username)
        val digitUserRoles: Set<DigitUserRole> = digitUser.roles
        logger.debug("Found roles for " + digitUser.username + ": " + digitUserRoles)
        val grantedAuthoritiesList: MutableList<GrantedAuthority> = ArrayList()
        for (role in digitUserRoles) {
            grantedAuthoritiesList.add(SimpleGrantedAuthority(role.role))
        }

        return User(
            digitUser.username, digitUser.password, digitUser.enabled,
            true,
            true,
            true,
            grantedAuthoritiesList
        )
    }
}