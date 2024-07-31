package com.renamrgb.hexagonal.application.ports.`in`

import com.renamrgb.hexagonal.application.core.domain.Customer

interface FindCustomerByIdInputPort {
    fun find(id: String): Customer
}