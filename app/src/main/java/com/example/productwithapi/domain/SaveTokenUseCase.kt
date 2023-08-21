package com.example.productwithapi.domain

import com.example.productwithapi.data.Repository

class SaveTokenUseCase(val repository: Repository=Repository()) {
    fun saveToken(token:String){
        repository.saveToken(token)
    }
    fun getToken():String?{
        return repository.getToken()
    }
}