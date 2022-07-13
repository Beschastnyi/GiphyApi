package com.example.myapplication.mainactivity.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.mainactivity.data.Data
import com.example.myapplication.mainactivity.domain.MainRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(private val repository: MainRepository) : ViewModel() {

    val gifList = MutableLiveData<List<Data>>()

    fun getGifs() {
        viewModelScope.launch {
            val response = repository.getGifs()
            if (response.isSuccessful) {
                gifList.postValue(response.body()?.data)
            }
        }
    }
}