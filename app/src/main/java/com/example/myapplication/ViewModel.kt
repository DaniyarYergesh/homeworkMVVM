package com.example.myapplication

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    private val _pinCode = MutableLiveData<String>()
    val pinCode = _pinCode

    fun pinCode(number: String){
        _pinCode.value = number
    }
}