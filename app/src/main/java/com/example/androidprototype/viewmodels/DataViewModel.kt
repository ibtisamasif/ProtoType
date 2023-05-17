package com.example.androidprototype.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidprototype.repos.MainRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class DataViewModel(private val repo: MainRepo): ViewModel() {
    private val _validateInputSharedFlow = MutableSharedFlow<Boolean>()
    val validateInputSharedFlow = _validateInputSharedFlow.asSharedFlow()

    private val _fetchDataSharedFlow = MutableSharedFlow<List<String>>()
    val fetchDataSharedFlow = _fetchDataSharedFlow.asSharedFlow()

    fun storeData(data: String) {
        viewModelScope.launch(Dispatchers.IO) {
            if (validateInput(data)) {
                repo.storeData(data)
                _validateInputSharedFlow.emit(true)
            } else {
                _validateInputSharedFlow.emit(false)
            }
        }
    }

    fun fetchData() {
        viewModelScope.launch(Dispatchers.IO) {
            val data = repo.fetchData()
            _fetchDataSharedFlow.emit(data)
        }
    }

    fun validateInput(data: String): Boolean {
        return data.isNotEmpty() && data.length <= 15
    }
}