package com.example.productwithapi.domain

import com.example.productwithapi.data.Repository
import com.example.productwithapi.data.module.ProductRequest

class UpdateProductUseCase(private val repository: Repository = Repository()) {
    suspend fun updateProductUseCase(productRequest: ProductRequest, i: Int):Any{
        return repository.updateProduct(productRequest,i)
    }
}