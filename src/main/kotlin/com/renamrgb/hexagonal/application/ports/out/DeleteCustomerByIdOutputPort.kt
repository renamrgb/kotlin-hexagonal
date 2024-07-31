package com.renamrgb.hexagonal.application.ports.out

interface DeleteCustomerByIdOutputPort {

    fun delete(id: String)
}