package com.renamrgb.hexagonal.adapters.out

import com.renamrgb.hexagonal.adapters.out.repositories.CustomerRepository
import com.renamrgb.hexagonal.adapters.out.repositories.entities.CustomerEntity
import com.renamrgb.hexagonal.application.core.domain.Customer
import com.renamrgb.hexagonal.application.ports.out.InsertCustomerOutputPort
import org.springframework.stereotype.Component

@Component
class InsertCustomerAdapter(
    private val customerRepository: CustomerRepository
) : InsertCustomerOutputPort {

    override fun insert(customer: Customer) {
        customerRepository.save(CustomerEntity(customer))
    }
}