package com.samuellfa.graphql.gql.types

import com.samuellfa.graphql.domain.entities.Product

class ProductInput {
    var name: String? = null
    var price: Double? = null
    var quantityInStock: Int? = null

    fun toModel() = Product(
        name = name!!,
        price = price!!,
        quantityInStock = quantityInStock!!
    )
}