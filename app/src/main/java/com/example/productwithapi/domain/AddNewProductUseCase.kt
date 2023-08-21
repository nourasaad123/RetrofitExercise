package com.example.productwithapi.domain

import com.example.productwithapi.data.Repository
import com.example.productwithapi.data.module.ProductRequest

class AddNewProductUseCase(val repository: Repository = Repository()) {
    suspend fun addNewProduct(productRequest: ProductRequest): Any {
        return repository.addNewProduct(productRequest)

    }
}