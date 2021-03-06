package com.desmonddavid.ctcapp.entities

import javax.persistence.*

@Entity
data class CtcUser(
    @Id
    @Column(unique = true, nullable = false, length = 30)
    val username: String,

    @Column(nullable = false)
    val password: String,

    @Column(nullable = false)
    val enabled: Boolean,

    @OneToMany(fetch= FetchType.LAZY)
    @JoinColumn(name = "username", referencedColumnName = "username")
    val roles: MutableSet<CtcUserRole>
) {
    override fun toString(): String {
        return "DigitUser(username='$username', password='$password', enabled=$enabled)"
    }
}

@Entity
data class CtcUserRole(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val userRoleId: Int,

    val username: String,

    val role: String
) {
    override fun toString(): String {
        return "DigitUserRole(userRoleId=$userRoleId, username='$username', role='$role')"
    }
}