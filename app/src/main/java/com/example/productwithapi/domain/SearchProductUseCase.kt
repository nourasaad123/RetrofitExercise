package com.example.productwithapi.domain

import com.example.productwithapi.data.Repository
import com.example.productwithapi.data.module.ProductModel

class SearchProductUseCase(private val repository: Repository= Repository()) {
    suspend fun searchProductUseCase(value:String):ProductModel{
        return repository.searchForProductList(value)
    }


}