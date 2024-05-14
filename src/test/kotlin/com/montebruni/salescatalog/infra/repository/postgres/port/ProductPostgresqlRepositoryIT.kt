package com.montebruni.salescatalog.infra.repository.postgres.port

import com.montebruni.salescatalog.common.DatabaseIT
import com.montebruni.salescatalog.fixture.createProductPostgresqlModel
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

class ProductPostgresqlRepositoryIT(
    @Autowired private val productRepository: ProductPostgresqlRepository
) : DatabaseIT(productRepository) {

    @Test
    fun `should save a product successfully`() {
        val saved = productRepository.save(createProductPostgresqlModel())
        val product = productRepository.findById(saved.id).get()

        assertNotNull(product)
        assertEquals(saved.id, product.id)
    }
}
