package com.example.a12_livedata

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel



class MyViewModel : ViewModel() {
    var count = MutableLiveData<Int>()
    var isEven = MutableLiveData<Boolean>()

    init {
        isEven.value = true
        count.value = 0
    }
    fun setCount(newValue:Int){
        count.value = (count.value)?.plus(newValue)
    }


}