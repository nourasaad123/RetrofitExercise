package com.example.productwithapi

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.productwithapi.data.NetworkService
import com.example.productwithapi.data.module.LoginRequest
import com.example.productwithapi.data.module.Product
import com.example.productwithapi.data.module.ProductRequest
import com.example.productwithapi.data.module.QuoteX
//import com.example.productwithapi.data.module.TokenRequest
import com.example.productwithapi.data.module.User
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.HttpURLConnection
import java.net.URL


class ListsViewModel : ViewModel() {
    val quoteList = mutableStateOf<List<QuoteX>>(emptyList())
    val productList = mutableStateOf<List<Product>>(emptyList())
    val userList = mutableStateOf<List<User>>(emptyList())
    var textFieldText = mutableStateOf("")


    var retrofit = Retrofit.Builder()
        .baseUrl("https://dummyjson.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val network = retrofit.create(NetworkService::class.java)

    init {

        try {
            viewModelScope.launch {
                val products = network.getProductList()
                productList.value = products.products
                val users = network.getUserList()
                userList.value = users.users
                val quotes = network.getQuoteList()
                quoteList.value = quotes.quotes
            }
        } catch (ex: Exception) {
            ex.printStackTrace()
        }

    }

    fun addProduct() {
        try {
            viewModelScope.launch {
                network.addNewProduct(ProductRequest("test test test"))
            }
        } catch (ex: Exception) {
            ex.printStackTrace()
        }

    }

    fun updateProduct() {
        try {
            viewModelScope.launch {
                network.updateProduct(ProductRequest("test test test"), 3)
            }
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
    }

    fun deleteProduct() {
        try {
            viewModelScope.launch {
                network.deleteProduct(5)
            }
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
    }

    fun searchProduct() {
        try {
            viewModelScope.launch {
                val products = network.searchForProductList(textFieldText.value)
                productList.value = products.products
            }
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
    }

    fun authProduct(authToken: String) {
        try {
            viewModelScope.launch {
                network.getAuthProductList("Bearer $authToken")

            }
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
    }
    /*
        fun fetchProductList(token: String) {
            val url = URL("https://api.example.com/products")
            val connection = url.openConnection() as HttpURLConnection
            connection.requestMethod = "GET"
            connection.setRequestProperty("Authorization", "Bearer$token")

        }

     */

    fun loginToken() {
        try {
            viewModelScope.launch {
                var loginResponse = network.login(LoginRequest("kminchelle", "0lelplR"))
                authProduct(loginResponse.token)
            }

        } catch (ex: Exception) {
            ex.printStackTrace()
        }
    }

}
