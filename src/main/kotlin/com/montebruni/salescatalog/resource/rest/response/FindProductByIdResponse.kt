package com.montebruni.salescatalog.resource.rest.response

import java.util.UUID

data class FindProductByIdResponse(
    val id: UUID,
    val description: String,
    val height: Double,
    val width: Double,
    val length: Double,
    val weight: Double,
    val price: Double,
)
