package com.jsm.bluemarble

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@ConfigurationPropertiesScan("com.jsm.bluemarble.config.properties")
@SpringBootApplication
class BlueMarbleApplication

fun main(args: Array<String>) {
    runApplication<BlueMarbleApplication>(*args)
}
