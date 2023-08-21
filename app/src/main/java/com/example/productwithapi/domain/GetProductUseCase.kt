package com.example.productwithapi.domain

import com.example.productwithapi.data.Repository
import com.example.productwithapi.data.module.ProductModel
import com.example.productwithapi.persentation.ui.CustomListItem

class GetProductUseCase (private val repository: Repository=Repository()){
    suspend fun getProduct(): List<CustomListItem> {
        return repository.getProducts().products.map {
            CustomListItem(
                title = it.brand, description = it.description
            )
        }


    }
}