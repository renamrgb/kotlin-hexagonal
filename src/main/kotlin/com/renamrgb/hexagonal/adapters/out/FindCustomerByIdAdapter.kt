package com.renamrgb.hexagonal.adapters.out

import com.renamrgb.hexagonal.adapters.out.repositories.CustomerRepository
import com.renamrgb.hexagonal.application.ports.out.FindCustomerByIdOutputPort
import org.springframework.stereotype.Component
import kotlin.jvm.optionals.getOrNull

@Component
class FindCustomerByIdAdapter(
    private val customerRepository: CustomerRepository
) : FindCustomerByIdOutputPort {

    override fun find(id: String) = customerRepository.findById(id)
        .getOrNull()
        ?.toCustomer()
}