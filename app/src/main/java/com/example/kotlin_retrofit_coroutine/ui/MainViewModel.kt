package com.example.kotlin_retrofit_coroutine.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlin_retrofit_coroutine.model.DataModel
import com.example.kotlin_retrofit_coroutine.repo.MainRepository
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.launch

class MainViewModel(private var mainRepository: MainRepository) : ViewModel() {

    private val completableDeferred = CompletableDeferred<DataModel>()

    init {
        viewModelScope.launch {
            val result = mainRepository.getData(1)
           completableDeferred.complete(result)
        }

    }

    suspend fun getData() = completableDeferred.await()
}