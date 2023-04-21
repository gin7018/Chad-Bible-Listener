package com.org.chad

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ChadApplication

fun main(args: Array<String>) {
	runApplication<ChadApplication>(*args)
}
