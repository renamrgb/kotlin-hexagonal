package com.renamrgb.hexagonal.adapters.out.repositories.entities

import com.renamrgb.hexagonal.application.core.domain.Customer
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.MongoId
import java.util.*

@Document(collection = "customers")
data class CustomerEntity(
    @MongoId val id: String = UUID.randomUUID().toString(),
    val name: String,
    val address: AddressEntity,
    val cpf: String,
    val isValid: Boolean
) {
    constructor(customer: Customer) : this(
        id = customer.id ?: UUID.randomUUID().toString(),
        name = customer.name,
        address = AddressEntity(customer.address!!),
        cpf = customer.cpf,
        isValid = customer.isValid
    )
    
    fun toCustomer() = Customer(id, name, address.toAddress(), cpf, isValid)
}
