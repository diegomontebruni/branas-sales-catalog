package com.montebruni.salescatalog.usecase.output

import java.util.*

data class FindProductByIdOutput(
    val id: UUID,
    val description: String,
    val height: Double,
    val width: Double,
    val length: Double,
    val weight: Double,
    val price: Double,
)
