package com.montebruni.salescatalog.infra.repository.postgres.adapter

import com.montebruni.salescatalog.domain.entity.Product
import com.montebruni.salescatalog.domain.port.ProductRepository
import com.montebruni.salescatalog.extensions.repository.postgres.toProduct
import com.montebruni.salescatalog.infra.repository.postgres.port.ProductPostgresqlRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class ProductPostgresqlAdapter(
    @Autowired private val productRepository: ProductPostgresqlRepository
) : ProductRepository {

    override fun findById(id: UUID): Product = productRepository.findById(id).get().toProduct()
}
