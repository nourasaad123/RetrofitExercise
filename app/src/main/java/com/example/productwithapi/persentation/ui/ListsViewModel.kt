package com.example.productwithapi.persentation.ui

import android.content.SharedPreferences
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import com.example.productwithapi.BaseViewModel
import com.example.productwithapi.data.module.LoginRequest
import com.example.productwithapi.data.module.ProductRequest
import com.example.productwithapi.domain.AddNewProductUseCase
import com.example.productwithapi.domain.AuthProductUseCase
import com.example.productwithapi.domain.DeleteProductUseCase
import com.example.productwithapi.domain.GetProductUseCase
import com.example.productwithapi.domain.LoginProductUseCase
import com.example.productwithapi.domain.SaveTokenUseCase
import com.example.productwithapi.domain.SearchProductUseCase
import com.example.productwithapi.domain.UpdateProductUseCase
import kotlinx.coroutines.launch


class ListsViewModel(
    private val getProductUseCase: GetProductUseCase = GetProductUseCase(),
    private val addNewProductUseCase: AddNewProductUseCase = AddNewProductUseCase(),
    private val deleteProductUseCase: DeleteProductUseCase = DeleteProductUseCase(),
    private val searchProductUseCase: SearchProductUseCase = SearchProductUseCase(),
    private val updateProductUseCase: UpdateProductUseCase = UpdateProductUseCase(),
    private val loginProductUseCase: LoginProductUseCase = LoginProductUseCase(),
    private val authProductUseCase: AuthProductUseCase = AuthProductUseCase(),
private val saveTokenUseCase:SaveTokenUseCase=SaveTokenUseCase()

) : BaseViewModel() {
    val productList = mutableStateOf<List<CustomListItem>>(emptyList())
    var textFieldText = mutableStateOf("")


    init {
        try {
            viewModelScope.launch {
                val products = getProductUseCase.getProduct()
                productList.value = products
            }
        } catch (ex: Exception) {
            ex.printStackTrace()
        }

    }

    fun addProduct() {
        try {
            viewModelScope.launch {
                addNewProductUseCase.addNewProduct(ProductRequest("test test test"))
            }
        } catch (ex: Exception) {
            ex.printStackTrace()
        }

    }

    fun updateProduct() {
        try {
            viewModelScope.launch {
                updateProductUseCase.updateProductUseCase(ProductRequest("test test test"), 3)
            }
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
    }

    fun deleteProduct() {
        try {
            viewModelScope.launch {
                deleteProductUseCase.deleteProduct(5)
            }
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
    }

    fun searchProduct() {
        try {
            viewModelScope.launch {
                val products = searchProductUseCase.searchProductUseCase(textFieldText.value)
                val transform = products.products.map {
                    CustomListItem(
                        title = it.brand, description = it.description
                    )
                }

                productList.value = transform
            }
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
    }


    private fun authProduct(authToken: String) {
        try {
            viewModelScope.launch {
                authProductUseCase.authProduct("Bearer ${authToken}")

            }
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
    }


    fun loginToken() {
        try {
            viewModelScope.launch(handler) {
                val loginResponse =
                    loginProductUseCase.loginToken(LoginRequest("kminchelle", "0lelplR"))
                authProduct(loginResponse.token)
            }

        } catch (ex: Exception) {
            ex.printStackTrace()
        }
    }



}
