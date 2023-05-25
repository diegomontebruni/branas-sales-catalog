package com.montebruni.salescatalog.domain.port

import com.montebruni.salescatalog.domain.entity.Product
import java.util.*

interface ProductRepository {
    fun findById(id: UUID): Product?
}
