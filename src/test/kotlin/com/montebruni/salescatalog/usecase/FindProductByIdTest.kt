package com.montebruni.salescatalog.usecase

import com.montebruni.salescatalog.common.UnitTests
import com.montebruni.salescatalog.domain.port.ProductRepository
import com.montebruni.salescatalog.fixture.createProduct
import com.montebruni.salescatalog.usecase.input.FindProductByIdInput
import io.mockk.confirmVerified
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.verify
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.util.UUID

class FindProductByIdTest(
    @MockK private val productRepository: ProductRepository,
) : UnitTests() {

    @InjectMockKs
    private lateinit var findProductById: FindProductById

    @AfterEach
    internal fun tearDown() {
        confirmVerified(productRepository)
    }

    @Test
    fun `should get a product successfully`() {
        val productId = UUID.randomUUID()
        val product = createProduct().copy(id = productId)

        every { productRepository.findById(productId) } returns product

        val response = findProductById.execute(FindProductByIdInput(id = productId))

        assertEquals(productId, response.id)

        verify { productRepository.findById(productId) }
    }

    @Test
    fun `should throw exception when product not found`() {
        val productId = UUID.randomUUID()

        every { productRepository.findById(productId) } throws IllegalArgumentException()

        assertThrows<IllegalArgumentException> { findProductById.execute(FindProductByIdInput(id = productId)) }

        verify { productRepository.findById(productId) }
    }
}
