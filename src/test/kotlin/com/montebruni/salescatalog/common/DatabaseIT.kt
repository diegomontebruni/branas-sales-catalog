package com.montebruni.salescatalog.common

import com.montebruni.salescatalog.configuration.jackson.JacksonConfiguration
import org.junit.jupiter.api.BeforeEach
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.context.annotation.Import
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.test.context.DynamicPropertyRegistry
import org.springframework.test.context.DynamicPropertySource
import org.testcontainers.containers.PostgreSQLContainer
import org.testcontainers.utility.DockerImageName

@DataJpaTest
@Import(JacksonConfiguration::class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class DatabaseIT(
    private val repositories: List<JpaRepository<*, *>> = emptyList()
) {

    constructor(repository: JpaRepository<*, *>) : this(listOf(repository))

    @BeforeEach
    fun cleanDb() = repositories.forEach { it.deleteAllInBatch() }

    companion object {
        @JvmStatic
        val postgresContainer = PostgreSQLContainer(DockerImageName.parse("postgres:14.7-alpine")).apply {
            withUsername("app_sales")
            withPassword("app_sales")
            withDatabaseName("sales")
        }.also { it.start() }

        @JvmStatic
        @DynamicPropertySource
        fun registerDynamicProperties(registry: DynamicPropertyRegistry) {
            registry.add("spring.datasource.url", postgresContainer::getJdbcUrl)
            registry.add("spring.datasource.username", postgresContainer::getUsername)
            registry.add("spring.datasource.password", postgresContainer::getPassword)
        }
    }
}
