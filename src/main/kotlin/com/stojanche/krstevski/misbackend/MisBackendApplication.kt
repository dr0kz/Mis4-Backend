package com.stojanche.krstevski.misbackend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@SpringBootApplication
@ConfigurationPropertiesScan
class MisBackendApplication

fun main(args: Array<String>) {
    runApplication<MisBackendApplication>(*args)
}
