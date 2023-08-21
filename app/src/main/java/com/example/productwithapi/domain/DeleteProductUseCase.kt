package com.example.productwithapi.domain

import com.example.productwithapi.data.Repository

class DeleteProductUseCase(private val repository: Repository = Repository()) {
    suspend fun deleteProduct(productID:Int){
        repository.deleteProduct(productID)
    }
}