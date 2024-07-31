package com.renamrgb.hexagonal.adapters.out.client

import com.renamrgb.hexagonal.adapters.out.client.response.AddressResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@FeignClient(
    name = "FindAddressByZipCodeClient",
    url = "\${client.address.url}",
)
interface FindAddressByZipCodeWereMockClient : FindByZipCodeClient {

    @GetMapping("/{zipCode}")
    override fun find(@PathVariable zipCode: String): AddressResponse
}