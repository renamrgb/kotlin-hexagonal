package com.renamrgb.hexagonal.adapters.out.repositories

import com.renamrgb.hexagonal.adapters.out.repositories.entities.CustomerEntity
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface CustomerRepository : MongoRepository<CustomerEntity, String>
