package com.renamrgb.hexagonal.config

import com.renamrgb.hexagonal.adapters.out.FindAddressByZipCodeAdapter
import com.renamrgb.hexagonal.adapters.out.SendCpfForValidationAdapter
import com.renamrgb.hexagonal.adapters.out.UpdateCustomerAdapter
import com.renamrgb.hexagonal.application.core.usecase.FindCustomerByIdUseCase
import com.renamrgb.hexagonal.application.core.usecase.UpdateCustomerUseCase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class UpdateCustomerConfig {

    @Bean
    fun updateCustomer(
        fincCustomerUseCase: FindCustomerByIdUseCase,
        findAddressByZipCodeAdapter: FindAddressByZipCodeAdapter,
        updateCustomerAdapter: UpdateCustomerAdapter,
        sendCpfForValidationAdapter: SendCpfForValidationAdapter
    ) = UpdateCustomerUseCase(
        fincCustomerUseCase, findAddressByZipCodeAdapter, updateCustomerAdapter, sendCpfForValidationAdapter
    )
}