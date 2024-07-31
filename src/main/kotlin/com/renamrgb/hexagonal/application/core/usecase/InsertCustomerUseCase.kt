package com.renamrgb.hexagonal.application.core.usecase

import com.renamrgb.hexagonal.application.core.domain.Customer
import com.renamrgb.hexagonal.application.ports.`in`.InsertCustomerInputPort
import com.renamrgb.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort
import com.renamrgb.hexagonal.application.ports.out.InsertCustomerOutputPort
import com.renamrgb.hexagonal.application.ports.out.SendCpfForValidationOutputPort

class InsertCustomerUseCase(
    private val findAddressByZipCodeOutputPort: FindAddressByZipCodeOutputPort,
    private val insertCustomerOutputPort: InsertCustomerOutputPort,
    private val sendCpfForValidationOutputPort: SendCpfForValidationOutputPort
) : InsertCustomerInputPort {

    override fun insert(customer: Customer, zipCode: String) {
        customer.apply {
            address = findAddressByZipCodeOutputPort.find(zipCode)
        }.let {
            insertCustomerOutputPort.insert(it)
            sendCpfForValidationOutputPort.send(it.cpf)
        }
    }
}