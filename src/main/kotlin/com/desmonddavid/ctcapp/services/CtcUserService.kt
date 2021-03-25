package com.desmonddavid.ctcapp.services

import com.desmonddavid.ctcapp.entities.CtcUser
import com.desmonddavid.ctcapp.entities.CtcUserRole
import com.desmonddavid.ctcapp.repositories.CtcUserRepository
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
class CtcUserService(private val ctcUserRepository: CtcUserRepository) : UserDetailsService {

    private val logger = LoggerFactory.getLogger(CtcUserService::class.java)

    @Transactional(readOnly = true)
    override fun loadUserByUsername(username: String?): UserDetails {
        logger.debug("Fetching user details for user: $username")
        val ctcUser: CtcUser = ctcUserRepository.findByUsername(username!!)
        logger.debug("Found username: " + ctcUser.username)
        val ctcUserRoles: Set<CtcUserRole> = ctcUser.roles
        logger.debug("Found roles for " + ctcUser.username + ": " + ctcUserRoles)
        val grantedAuthoritiesList: MutableList<GrantedAuthority> = ArrayList()
        for (role in ctcUserRoles) {
            grantedAuthoritiesList.add(SimpleGrantedAuthority(role.role))
        }

        return User(
            ctcUser.username, ctcUser.password, ctcUser.enabled,
            true,
            true,
            true,
            grantedAuthoritiesList
        )
    }
}