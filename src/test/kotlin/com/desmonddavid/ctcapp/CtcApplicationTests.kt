package com.desmonddavid.ctcapp

import com.desmonddavid.ctcapp.repositories.CtcUserRepository
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class CtcApplicationTests(
	@Autowired
	val ctcUserRepository: CtcUserRepository
) {

	@Test
	fun contextLoads() {
		assertTrue(true)
	}

	@Test
	@DisplayName("Test reading values from the user table")
	fun digitUserRepositoryTest() {
		val digitUser = ctcUserRepository.findById("desmond").get()
		assertNotNull(digitUser)
		println(digitUser.username)
	}
}
