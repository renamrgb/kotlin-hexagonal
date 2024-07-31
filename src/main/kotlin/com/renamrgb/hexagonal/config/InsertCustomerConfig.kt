package com.renamrgb.hexagonal.config

import com.renamrgb.hexagonal.adapters.out.FindAddressByZipCodeAdapter
import com.renamrgb.hexagonal.adapters.out.InsertCustomerAdapter
import com.renamrgb.hexagonal.adapters.out.SendCpfForValidationAdapter
import com.renamrgb.hexagonal.application.core.usecase.InsertCustomerUseCase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class InsertCustomerConfig {

    @Bean
    fun insertCustomer(
        findAddressByZipCodeAdapter: FindAddressByZipCodeAdapter,
        insertCustomerAdapter: InsertCustomerAdapter,
        sendCpfForValidationAdapter: SendCpfForValidationAdapter
    ) = InsertCustomerUseCase(findAddressByZipCodeAdapter, insertCustomerAdapter, sendCpfForValidationAdapter)

}