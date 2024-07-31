package com.renamrgb.hexagonal.config

import com.renamrgb.hexagonal.adapters.out.FindCustomerByIdAdapter
import com.renamrgb.hexagonal.application.core.usecase.FindCustomerByIdUseCase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class FindCustomerByIdConfig {

    @Bean
    fun findCustomerById(
        findCustomerByIdAdapter: FindCustomerByIdAdapter
    ) = FindCustomerByIdUseCase(findCustomerByIdAdapter)
}