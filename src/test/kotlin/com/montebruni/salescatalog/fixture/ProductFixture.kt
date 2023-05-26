package com.montebruni.salescatalog.fixture

import com.montebruni.salescatalog.domain.entity.Product
import com.montebruni.salescatalog.domain.valueobjects.Amount
import com.montebruni.salescatalog.domain.valueobjects.PositiveDouble
import java.util.*

fun createProduct() = Product(
    id = UUID.randomUUID(),
    description = "Camera",
    height = PositiveDouble(20),
    width = PositiveDouble(15),
    length = PositiveDouble(10),
    weight = PositiveDouble(1),
    price = Amount("10")
)
