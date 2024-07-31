package com.renamrgb.hexagonal.application.core.usecase

import com.renamrgb.hexagonal.application.core.exceptions.ObjectNotFoundException
import com.renamrgb.hexagonal.application.ports.`in`.FindCustomerByIdInputPort
import com.renamrgb.hexagonal.application.ports.out.FindCustomerByIdOutputPort

class FindCustomerByIdUseCase(
    private val findCustomerByIdOutputPort: FindCustomerByIdOutputPort
) : FindCustomerByIdInputPort {

    override fun find(id: String) =
        findCustomerByIdOutputPort.find(id) ?: throw ObjectNotFoundException("Customer with id $id not found")
}