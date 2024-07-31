package com.renamrgb.hexagonal.adapters.out

import com.renamrgb.hexagonal.adapters.out.repositories.CustomerRepository
import com.renamrgb.hexagonal.application.ports.out.DeleteCustomerByIdOutputPort
import org.springframework.stereotype.Component

@Component
class DeleteCustomerByIdAdapter(
    private val customerRepository: CustomerRepository
) : DeleteCustomerByIdOutputPort {

    override fun delete(id: String) {
        customerRepository.deleteById(id)
    }
}