package com.renamrgb.hexagonal.application.ports.`in`

import com.renamrgb.hexagonal.application.core.domain.Customer

interface InsertCustomerInputPort {

    fun insert(customer: Customer, zipCode: String)
}