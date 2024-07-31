package com.renamrgb.hexagonal.adapters.out.client

import com.renamrgb.hexagonal.adapters.out.client.response.AddressResponse

interface FindByZipCodeClient {
    fun find(zipCode: String): AddressResponse
}