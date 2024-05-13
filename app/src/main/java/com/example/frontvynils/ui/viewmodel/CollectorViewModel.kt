package com.example.frontvynils.ui.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.frontvynils.models.Collector
import com.example.frontvynils.network.RetrofitInstance
import com.example.frontvynils.repository.CollectorRepository
import kotlinx.coroutines.launch

class CollectorViewModel : ViewModel() {
    private val repository = CollectorRepository(RetrofitInstance.api)

    var collectors = mutableStateOf<List<Collector>>(listOf())
        private set

    init {
        viewModelScope.launch {
            collectors.value = repository.getCollectors()
        }
    }
}