package com.montebruni.salescatalog.resource.rest

import com.montebruni.salescatalog.common.BaseRestIT
import com.montebruni.salescatalog.fixture.createFindProductByIdOutput
import com.montebruni.salescatalog.usecase.FindProductById
import com.montebruni.salescatalog.usecase.input.FindProductByIdInput
import com.ninjasquad.springmockk.MockkBean
import io.mockk.confirmVerified
import io.mockk.every
import io.mockk.verify
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import java.util.*

@WebMvcTest(controllers = [ProductController::class])
class ProductResourceIT : BaseRestIT() {

    @MockkBean
    private lateinit var findProductById: FindProductById

    @AfterEach
    internal fun tearDown() {
        confirmVerified(findProductById)
    }

    private val baseUrl = "/v1/products"

    @Test
    fun `should returns status 200 with product`() {
        val productId = UUID.randomUUID()
        val product = createFindProductByIdOutput()
        val productInput = FindProductByIdInput(productId)

        every { findProductById.execute(productInput) } returns product

        mockMvc.perform(
            MockMvcRequestBuilders.get("$baseUrl/$productId")
                .contentType(MediaType.APPLICATION_JSON)
        )
            .andExpect(MockMvcResultMatchers.status().is2xxSuccessful)
            .andExpect(MockMvcResultMatchers.jsonPath("id").value(product.id.toString()))
            .andExpect(MockMvcResultMatchers.jsonPath("description").value(product.description))
            .andExpect(MockMvcResultMatchers.jsonPath("height").value(product.height))
            .andExpect(MockMvcResultMatchers.jsonPath("width").value(product.width))
            .andExpect(MockMvcResultMatchers.jsonPath("length").value(product.length))
            .andExpect(MockMvcResultMatchers.jsonPath("weight").value(product.weight))
            .andExpect(MockMvcResultMatchers.jsonPath("price").value(product.price))

        verify { findProductById.execute(productInput) }
    }
}
