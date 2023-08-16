package com.example.productwithapi.data

import com.example.productwithapi.data.module.LoginRequest
import com.example.productwithapi.data.module.LoginResponse
import com.example.productwithapi.data.module.ProductModel
import com.example.productwithapi.data.module.ProductRequest
import com.example.productwithapi.data.module.QuoteModel
//import com.example.productwithapi.data.module.TokenRequest
import com.example.productwithapi.data.module.UserModel
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

//https://dummyjson.com/
interface NetworkService {
    @GET("quotes")
    suspend fun getQuoteList(): QuoteModel

    @GET("products")
    suspend fun getProductList(): ProductModel

    @GET("users")
    suspend fun getUserList(): UserModel

    @POST("products/add")
    suspend fun addNewProduct(@Body productRequest: ProductRequest): Any

    @POST("auth/login")
    suspend fun login(@Body loginRequset: LoginRequest): LoginResponse

    @PUT("products/{productId}")
    suspend fun updateProduct(
        @Body productRequest: ProductRequest,
        @Path("productId") productID: Int
    ): Any

    @DELETE("products/{productId}")
    suspend fun deleteProduct(@Path("productId") productID: Int): Any

    @GET("products/search")
    suspend fun searchForProductList(@Query("q") searchQuery: String): ProductModel

    @GET("auth/products")
    suspend fun getAuthProductList(@Header("Authorization") apikey: String): ProductModel

}