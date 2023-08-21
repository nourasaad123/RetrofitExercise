package com.example.productwithapi

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class SecondViewModel:BaseViewModel() {
     fun getCards(){
    viewModelScope.launch {

    }
    }
}