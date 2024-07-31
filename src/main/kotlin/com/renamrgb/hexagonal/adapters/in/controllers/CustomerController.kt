package com.renamrgb.hexagonal.adapters.`in`.controllers

import com.renamrgb.hexagonal.adapters.`in`.controllers.request.CustomerRequest
import com.renamrgb.hexagonal.adapters.`in`.controllers.response.CustomerResponse
import com.renamrgb.hexagonal.application.core.domain.Customer
import com.renamrgb.hexagonal.application.ports.`in`.DeleteCustomerByIdInputPort
import com.renamrgb.hexagonal.application.ports.`in`.FindCustomerByIdInputPort
import com.renamrgb.hexagonal.application.ports.`in`.InsertCustomerInputPort
import com.renamrgb.hexagonal.application.ports.`in`.UpdateCustomerInputPort
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/customers")
class CustomerController(
    private val insertCustomerInputPort: InsertCustomerInputPort,
    private val findCustomerByIdInputPort: FindCustomerByIdInputPort,
    private val updateCustomerInputPort: UpdateCustomerInputPort,
    private val deleteCustomerByIdInputPort: DeleteCustomerByIdInputPort
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun insert(@Valid @RequestBody request: CustomerRequest) {
        with(request) {
            val customer = Customer(name = name, cpf = cpf)
            insertCustomerInputPort.insert(customer, zipCode)
        }
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    fun findById(@PathVariable id: String): CustomerResponse {
        val customer = findCustomerByIdInputPort.find(id)
        return CustomerResponse(customer)
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun update(@PathVariable id: String, @Valid @RequestBody request: CustomerRequest) {
        with(request) {
            val customer = Customer(id = id, name = name, cpf = cpf)
            updateCustomerInputPort.update(customer, request.zipCode)
        }
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: String) = deleteCustomerByIdInputPort.delete(id)
}