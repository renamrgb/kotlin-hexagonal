package com.renamrgb.hexagonal.adapters.out.repositories.entities

import com.renamrgb.hexagonal.application.core.domain.Address

data class AddressEntity(
    var street: String,
    var city: String,
    var state: String,
) {
    constructor(address: Address) : this(
        street = address.street,
        city = address.city,
        state = address.state
    )

    fun toAddress() = Address(street, city, state)
}
