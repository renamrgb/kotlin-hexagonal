package com.renamrgb.hexagonal.config

import com.renamrgb.hexagonal.adapters.out.DeleteCustomerByIdAdapter
import com.renamrgb.hexagonal.application.core.usecase.DeleteCustomerByIdUseCase
import com.renamrgb.hexagonal.application.core.usecase.FindCustomerByIdUseCase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class DeleteCustomerByIdConfig {

    @Bean
    fun deleteCustomer(
        findCustomerByIdUseCase: FindCustomerByIdUseCase,
        deleteCustomerByIdAdapter: DeleteCustomerByIdAdapter
    ) = DeleteCustomerByIdUseCase(findCustomerByIdUseCase, deleteCustomerByIdAdapter)
}