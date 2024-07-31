package com.renamrgb.hexagonal.application.core.usecase

import com.renamrgb.hexagonal.application.ports.`in`.DeleteCustomerByIdInputPort
import com.renamrgb.hexagonal.application.ports.`in`.FindCustomerByIdInputPort
import com.renamrgb.hexagonal.application.ports.out.DeleteCustomerByIdOutputPort

class DeleteCustomerByIdUseCase(
    private val findCustomerByIdInputPort: FindCustomerByIdInputPort,
    private val deleteCustomerOutputPort: DeleteCustomerByIdOutputPort,
) : DeleteCustomerByIdInputPort {

    override fun delete(id: String) {
        checkExistsCustomer(id)
        deleteCustomerOutputPort.delete(id)
    }

    private fun checkExistsCustomer(id: String) {
        findCustomerByIdInputPort.find(id)
    }
}