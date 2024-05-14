package com.montebruni.salescatalog.resource.rest

import com.montebruni.salescatalog.resource.rest.response.FindProductByIdResponse
import com.montebruni.salescatalog.resource.rest.response.from
import com.montebruni.salescatalog.usecase.FindProductById
import com.montebruni.salescatalog.usecase.input.FindProductByIdInput
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("v1/products")
class ProductController(
    private val findProductById: FindProductById
) {

    @Operation(
        summary = "Find product",
        description = "Returns 200 with the response",
        tags = ["Product"]
    )
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "Product retrieve with successfully"),
        ]
    )
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    fun findProductById(
        @Schema(description = "id", example = "8378c23d-8502-47d9-b364-a100b7a7d840")
        @PathVariable id: UUID
    ) =
        FindProductByIdInput(id)
            .let(findProductById::execute)
            .let(FindProductByIdResponse::from)
}
