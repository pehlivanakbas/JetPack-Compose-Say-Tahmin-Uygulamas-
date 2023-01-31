package com.iottech.listexample.ui.theme

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    val textfieldState = MutableLiveData("")
    fun onTextChanged(value: String) {
        textfieldState.value = value
    }


}