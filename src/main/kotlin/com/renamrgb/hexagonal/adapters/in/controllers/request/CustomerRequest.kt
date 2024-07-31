package com.renamrgb.hexagonal.adapters.`in`.controllers.request

import jakarta.validation.constraints.NotBlank

data class CustomerRequest(
    @field:NotBlank(message = "name must not be blank")
    val name: String,
    @field:NotBlank(message = "name must not be cpf")
    val cpf: String,
    @field:NotBlank(message = "name must not be zipCode")
    val zipCode: String
)
