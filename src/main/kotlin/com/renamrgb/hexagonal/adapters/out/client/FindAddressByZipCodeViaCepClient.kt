package com.renamrgb.hexagonal.adapters.out.client

import com.renamrgb.hexagonal.adapters.out.client.response.AddressResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable


@FeignClient(
    name = "FindAddressByZipCodeViaCepClient",
    url = "\${via-cep.url}",
)
interface IFindAddressByZipCodeViaCepClient {

    @GetMapping("/{zipCode}/json")
    fun find(@PathVariable zipCode: String): ViaCepResponse
}

@Component("FindAddressByZipCodeViaCepClient")
class FindAddressByZipCodeViaCepClient(
    private val iFindAddressByZipCodeViaCepClient: IFindAddressByZipCodeViaCepClient
) : FindByZipCodeClient {
    override fun find(@PathVariable zipCode: String): AddressResponse {
        val address = iFindAddressByZipCodeViaCepClient.find(zipCode)
        return AddressResponse(address.logradouro, address.localidade, address.uf)
    }
}

data class ViaCepResponse(
    val logradouro: String,
    val localidade: String,
    val uf: String
)