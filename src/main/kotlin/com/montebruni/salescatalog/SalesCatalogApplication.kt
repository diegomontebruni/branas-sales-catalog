package com.montebruni.salescatalog

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@SpringBootApplication
@ConfigurationPropertiesScan
class SalesCatalogApplication

@Suppress("SpreadOperator")
fun main(args: Array<String>) {
    runApplication<SalesCatalogApplication>(*args)
}
