package com.samuellfa.graphql.domain.entities

import org.hibernate.Hibernate
import javax.persistence.*

@Entity
@Table(name="products")
data class Product (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Long? = null,
    @Column(name = "name", nullable = false)
    var name: String,
    @Column(name = "price", nullable = false)
    val price: Double,
    @Column(name = "quantity_in_stock", nullable = false)
    val quantityInStock: Int) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as Product

        return id != null && id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id , name = $name , price = $price , quantityInStock = $quantityInStock )"
    }
}