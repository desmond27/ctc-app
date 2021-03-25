package com.desmonddavid.ctcapp.repositories

import com.desmonddavid.ctcapp.entities.CtcUser
import com.desmonddavid.ctcapp.entities.CtcUserRole
import org.springframework.data.jpa.repository.JpaRepository

interface CtcUserRepository: JpaRepository<CtcUser, String> {
    fun findByUsername(username: String): CtcUser
}

interface CtcUserRoleRepository: JpaRepository<CtcUserRole, Int> {

}