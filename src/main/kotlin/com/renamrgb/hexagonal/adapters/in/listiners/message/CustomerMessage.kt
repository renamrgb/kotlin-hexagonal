package com.renamrgb.hexagonal.adapters.`in`.listiners.message

import com.renamrgb.hexagonal.application.core.domain.Customer

class CustomerMessage(
    val id: String,
    val name: String,
    val zipCode: String,
    val cpf: String,
    val isValidCpf: Boolean
) {
    fun toCustomer() = Customer(id, name, cpf = cpf, isValid = isValidCpf)
}