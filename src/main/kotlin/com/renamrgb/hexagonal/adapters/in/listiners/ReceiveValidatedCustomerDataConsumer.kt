package com.renamrgb.hexagonal.adapters.`in`.listiners

import com.renamrgb.hexagonal.adapters.`in`.listiners.message.CustomerMessage
import com.renamrgb.hexagonal.application.ports.`in`.UpdateCustomerInputPort
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
class ReceiveValidatedCustomerDataConsumer(
    private val updateCustomerInputPort: UpdateCustomerInputPort
) {

    @KafkaListener(topics = ["tp-cpf-validated"], groupId = "hexagonal")
    fun receive(message: CustomerMessage) {
        with(message) {
            updateCustomerInputPort.update(toCustomer(), zipCode)
        }
    }
}