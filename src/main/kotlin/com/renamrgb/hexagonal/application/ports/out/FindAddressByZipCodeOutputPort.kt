package com.renamrgb.hexagonal.application.ports.out

import com.renamrgb.hexagonal.application.core.domain.Address

interface FindAddressByZipCodeOutputPort {
    fun find(zipCode: String): Address
}