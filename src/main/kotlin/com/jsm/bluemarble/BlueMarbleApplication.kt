package com.jsm.bluemarble

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BlueMarbleApplication

fun main(args: Array<String>) {
	runApplication<BlueMarbleApplication>(*args)
}
