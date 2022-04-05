package com.samuellfa.graphql.gql

import com.fasterxml.jackson.databind.ObjectMapper
import com.samuellfa.graphql.domain.entities.Product
import com.samuellfa.graphql.domain.services.ProductService
import com.samuellfa.graphql.gql.types.ProductInput
import graphql.schema.DataFetcher
import graphql.schema.DataFetchingEnvironment
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component


@Component
class DataFetchers(@Autowired val productService: ProductService) {
    val objectMapper: ObjectMapper = ObjectMapper()

    fun createPost(): DataFetcher<Product>? {
        return DataFetcher { dfe: DataFetchingEnvironment ->
            val input = dfe.getArgument<Any>("product")
            val productInput = objectMapper.convertValue(input, ProductInput::class.java)
            productService.create(productInput.toModel())
        }
    }

    fun findByName(): DataFetcher<Product>? {
        return DataFetcher<Product> { dfe: DataFetchingEnvironment ->
            val productName: String = dfe.getArgument("name")
            productService.findByName(productName)
        }
    }
}