package com.montebruni.salescatalog.usecase

import com.montebruni.salescatalog.domain.port.ProductRepository
import com.montebruni.salescatalog.usecase.input.FindProductByIdInput
import com.montebruni.salescatalog.usecase.output.FindProductByIdOutput
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class FindProductById(
    @Autowired private val productRepository: ProductRepository,
) {

    fun execute(input: FindProductByIdInput): FindProductByIdOutput = productRepository.findById(input.id)?.let {
        FindProductByIdOutput(
            id = it.id,
            description = it.description,
            height = it.height.value,
            width = it.width.value,
            length = it.length.value,
            weight = it.weight.value,
            price = it.price.value.toDouble()
        )
    } ?: throw IllegalArgumentException("Product not found")
}
