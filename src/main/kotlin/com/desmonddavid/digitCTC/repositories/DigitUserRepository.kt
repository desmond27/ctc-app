package com.desmonddavid.digitCTC.repositories

import com.desmonddavid.digitCTC.entities.DigitUser
import com.desmonddavid.digitCTC.entities.DigitUserRole
import org.springframework.data.jpa.repository.JpaRepository

interface DigitUserRepository: JpaRepository<DigitUser, String> {
    fun findByUsername(username: String): DigitUser
}

interface DigitUserRoleRepository: JpaRepository<DigitUserRole, Int> {

}