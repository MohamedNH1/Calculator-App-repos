package com.example.calculator

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel :ViewModel() {

    var resultDemo = MutableLiveData<String?>()

    init {
        resultDemo.value = ""
    }


    fun setResult(result:String?){
        resultDemo.value = result
    }

}