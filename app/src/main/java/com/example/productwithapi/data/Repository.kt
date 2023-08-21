package com.example.productwithapi.data

import com.example.productwithapi.data.module.LoginRequest
import com.example.productwithapi.data.module.LoginResponse
import com.example.productwithapi.data.module.ProductModel
import com.example.productwithapi.data.module.ProductRequest
import com.example.productwithapi.data.network.NetworkService
import com.example.productwithapi.data.persestance.AppSharedPreference
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Repository {

    var retrofit = Retrofit.Builder()
        .baseUrl("https://dummyjson.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val network = retrofit.create(NetworkService::class.java)
val sharedPref=AppSharedPreference()
    suspend fun getProducts(): ProductModel {
        return network.getProductList()
    }

    suspend fun addNewProduct(productRequest: ProductRequest): Any {
        return network.addNewProduct(productRequest)
    }

    suspend fun login(loginRequest: LoginRequest): LoginResponse {
        return network.login(loginRequest = loginRequest)

    }

    suspend fun getAuthProductList(s: String): LoginResponse {
        return network.getAuthProductList("Bearer $s")

    }

    suspend fun searchForProductList(value: String): ProductModel {
        return network.searchForProductList(searchQuery = value)
    }

    suspend fun deleteProduct(i: Int): Any {
        return network.deleteProduct(i)
    }

    suspend fun updateProduct(productRequest: ProductRequest, i: Int): Any {
        return network.updateProduct(productRequest, i)
    }

    fun saveToken(token: String) {
sharedPref.saveToken(token)
    }
    fun getToken() :String?{
        return sharedPref.getToken()
    }
}