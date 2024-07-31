package com.renamrgb.hexagonal.application.ports.out

import com.renamrgb.hexagonal.application.core.domain.Customer

interface UpdateCustomerOutputPort {

    fun update(customer: Customer)
}