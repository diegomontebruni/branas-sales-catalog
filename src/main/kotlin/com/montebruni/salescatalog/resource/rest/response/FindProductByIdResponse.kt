package com.montebruni.salescatalog.resource.rest.response

import com.montebruni.salescatalog.usecase.output.FindProductByIdOutput
import java.util.UUID

data class FindProductByIdResponse(
    val id: UUID,
    val description: String,
    val height: Double,
    val width: Double,
    val length: Double,
    val weight: Double,
    val price: Double,
) {
    companion object
}

fun FindProductByIdResponse.Companion.from(output: FindProductByIdOutput) = FindProductByIdOutput(
    id = output.id,
    description = output.description,
    height = output.height,
    width = output.width,
    length = output.length,
    weight = output.weight,
    price = output.price
)
