package com.renamrgb.hexagonal.adapters.out

import com.renamrgb.hexagonal.adapters.out.repositories.CustomerRepository
import com.renamrgb.hexagonal.adapters.out.repositories.entities.CustomerEntity
import com.renamrgb.hexagonal.application.core.domain.Customer
import com.renamrgb.hexagonal.application.ports.out.UpdateCustomerOutputPort
import org.springframework.stereotype.Component

@Component
class UpdateCustomerAdapter(
    private val customerRepository: CustomerRepository
) : UpdateCustomerOutputPort {

    override fun update(customer: Customer) {
        customerRepository.save(CustomerEntity(customer))
    }

}