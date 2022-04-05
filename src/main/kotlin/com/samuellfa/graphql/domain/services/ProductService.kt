package com.samuellfa.graphql.domain.services

import com.samuellfa.graphql.domain.entities.Product
import com.samuellfa.graphql.domain.repositories.ProductRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ProductService (@Autowired var repository: ProductRepository) {

    fun create(product: Product): Product {
        return repository.save(product)
    }

    fun findByName(name: String): Product? {
        return repository.findByName(name)
    }
}