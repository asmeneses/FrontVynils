package com.example.frontvynils.ui.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.frontvynils.models.Collector
import com.example.frontvynils.repository.ICollectorRepository
import kotlinx.coroutines.launch

class CollectorsViewModel(private val repository: ICollectorRepository) : ViewModel() {
    var collectors = mutableStateOf<List<Collector>>(listOf())
        private set

    init {
        viewModelScope.launch {
            collectors.value = repository.getCollectors()
        }
    }
}