package com.renamrgb.hexagonal.adapters.`in`.controllers.response

import com.renamrgb.hexagonal.application.core.domain.Address

data class AddressResponse(
    val street: String,
    val city: String,
    val state: String,
) {
    constructor(address: Address) : this(
        street = address.street,
        city = address.city,
        state = address.state,
    )
}
