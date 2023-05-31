package com.montebruni.salescatalog.domain.entity

import com.montebruni.salescatalog.domain.valueobjects.Amount
import com.montebruni.salescatalog.domain.valueobjects.PositiveDouble
import java.util.*

data class Product(
    val id: UUID,
    val description: String,
    val height: PositiveDouble,
    val width: PositiveDouble,
    val length: PositiveDouble,
    val weight: PositiveDouble,
    val price: Amount,
)
