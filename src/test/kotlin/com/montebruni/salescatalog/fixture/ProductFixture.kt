package com.montebruni.salescatalog.fixture

import com.montebruni.salescatalog.domain.entity.Product
import com.montebruni.salescatalog.domain.valueobjects.Amount
import com.montebruni.salescatalog.domain.valueobjects.PositiveDouble
import com.montebruni.salescatalog.infra.repository.postgres.model.ProductPostgresqlModel
import com.montebruni.salescatalog.usecase.output.FindProductByIdOutput
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

fun createFindProductByIdOutput() = FindProductByIdOutput(
    id = UUID.randomUUID(),
    description = "Camera",
    height = 20.0,
    width = 15.0,
    length = 10.0,
    weight = 1.0,
    price = 10.0
)

fun createProductPostgresqlModel() = ProductPostgresqlModel(
    id = UUID.randomUUID(),
    description = "Camera",
    height = 20.0,
    width = 15.0,
    length = 10.0,
    weight = 1.0,
    price = 100.0
)
