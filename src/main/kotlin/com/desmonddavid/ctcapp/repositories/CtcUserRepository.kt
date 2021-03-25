package com.desmonddavid.ctcapp.repositories

import com.desmonddavid.ctcapp.entities.DigitUser
import com.desmonddavid.ctcapp.entities.DigitUserRole
import org.springframework.data.jpa.repository.JpaRepository

interface DigitUserRepository: JpaRepository<DigitUser, String> {
    fun findByUsername(username: String): DigitUser
}

interface DigitUserRoleRepository: JpaRepository<DigitUserRole, Int> {

}