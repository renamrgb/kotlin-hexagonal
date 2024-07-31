package com.renamrgb.hexagonal.application.core.usecase

import com.renamrgb.hexagonal.application.core.domain.Customer
import com.renamrgb.hexagonal.application.ports.`in`.FindCustomerByIdInputPort
import com.renamrgb.hexagonal.application.ports.`in`.UpdateCustomerInputPort
import com.renamrgb.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort
import com.renamrgb.hexagonal.application.ports.out.SendCpfForValidationOutputPort
import com.renamrgb.hexagonal.application.ports.out.UpdateCustomerOutputPort

class UpdateCustomerUseCase(
    private val findCustomerByIdInputPort: FindCustomerByIdInputPort,
    private val findAddressByZipCodeOutputPort: FindAddressByZipCodeOutputPort,
    private val updateCustomerOutputPort: UpdateCustomerOutputPort,
    private val sendCpfForValidationOutputPort: SendCpfForValidationOutputPort
) : UpdateCustomerInputPort {

    override fun update(customer: Customer, zipCode: String) {
        requireNotNull(customer.id) { "Customer ID cannot be null" }
        val savedCpf = findCustomerByIdInputPort.find(customer.id).cpf

        val updatedCustomer = customer.apply {
            address = findAddressByZipCodeOutputPort.find(zipCode)
        }
        if (!savedCpf.equals(customer.cpf)) {
            sendCpfForValidationOutputPort.send(customer.cpf)
        }
        updateCustomerOutputPort.update(updatedCustomer)
    }
}