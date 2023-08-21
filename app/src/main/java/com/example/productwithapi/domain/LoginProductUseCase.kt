package com.example.productwithapi.domain

import com.example.productwithapi.data.Repository
import com.example.productwithapi.data.module.LoginRequest
import com.example.productwithapi.data.module.LoginResponse

class LoginProductUseCase(val repository: Repository = Repository()) {
    suspend fun loginToken(loginRequest: LoginRequest):LoginResponse{
        return repository.login(loginRequest)
    }
}