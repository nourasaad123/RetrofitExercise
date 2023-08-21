package com.example.productwithapi.domain

import com.example.productwithapi.data.Repository
import com.example.productwithapi.data.module.LoginResponse

class AuthProductUseCase(private val repository: Repository = Repository()) {
    suspend fun authProduct(s: String):LoginResponse{
        return repository.getAuthProductList(s)
    }
}