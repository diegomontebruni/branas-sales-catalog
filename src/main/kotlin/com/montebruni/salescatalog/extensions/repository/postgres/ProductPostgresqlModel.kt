package com.montebruni.salescatalog.extensions.repository.postgres

import com.montebruni.salescatalog.domain.entity.Product
import com.montebruni.salescatalog.domain.valueobjects.Amount
import com.montebruni.salescatalog.extensions.toPositiveDouble
import com.montebruni.salescatalog.infra.repository.postgres.model.ProductPostgresqlModel

fun ProductPostgresqlModel.toProduct() = Product(
    id = id,
    description = description,
    height = height.toPositiveDouble(),
    width = width.toPositiveDouble(),
    length = length.toPositiveDouble(),
    weight = weight.toPositiveDouble(),
    price = Amount(price)
)
