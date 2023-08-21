package com.example.productwithapi

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException

open class BaseViewModel : ViewModel() {
    var sharedFlow = MutableSharedFlow<String>()

    val handler = CoroutineExceptionHandler { context, exception ->
        println("Caught $exception")
        if (exception is HttpException) {
            when (exception.code()) {
                400 -> {
                    println("Caught Error is 400 and the response is bad response")
                    viewModelScope.launch {
                        sharedFlow.emit("Caught Error is 400 and the response is bad response")
                    }
                }

                500 -> {
                    println("Caught Internal Server Error")
                    viewModelScope.launch {
                        sharedFlow.emit("Caught Internal Server Error")
                    }
                }

                401 -> {
                    println("Caught Un Authorized")
                    viewModelScope.launch {
                        sharedFlow.emit("Caught Un Authorized")
                    }
                }
            }
        }
    }
}