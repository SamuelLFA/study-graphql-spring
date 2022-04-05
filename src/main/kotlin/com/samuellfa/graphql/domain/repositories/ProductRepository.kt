package com.samuellfa.graphql.domain.repositories

import com.samuellfa.graphql.domain.entities.Product
import org.springframework.data.repository.CrudRepository

interface ProductRepository: CrudRepository<Product, Long> {
    fun findByName(name: String): Product?
}