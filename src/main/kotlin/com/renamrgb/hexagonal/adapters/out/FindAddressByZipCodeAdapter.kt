package com.renamrgb.hexagonal.adapters.out

import com.renamrgb.hexagonal.adapters.out.client.FindAddressByZipCodeViaCepClient
import com.renamrgb.hexagonal.adapters.out.client.FindAddressByZipCodeWereMockClient
import com.renamrgb.hexagonal.adapters.out.client.FindByZipCodeClient
import com.renamrgb.hexagonal.application.core.domain.Address
import com.renamrgb.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Component

@Component
class FindAddressByZipCodeAdapter(
    private val findAddressByZipCodeClient: FindAddressByZipCodeWereMockClient,
    @Qualifier("FindAddressByZipCodeViaCepClient") private val findByZipCodeClient: FindByZipCodeClient
) : FindAddressByZipCodeOutputPort {

    override fun find(zipCode: String): Address =
        findByZipCodeClient.find(zipCode).toAddress()
}