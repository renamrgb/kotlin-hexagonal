package com.renamrgb.hexagonal.application.ports.`in`

import com.renamrgb.hexagonal.application.core.domain.Customer

interface UpdateCustomerInputPort {

    fun update(customer: Customer, zipCode: String)
}