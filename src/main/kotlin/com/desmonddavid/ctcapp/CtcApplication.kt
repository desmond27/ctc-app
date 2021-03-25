package com.desmonddavid.ctcapp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CtcApplication

fun main(args: Array<String>) {
	runApplication<CtcApplication>(*args)
}
