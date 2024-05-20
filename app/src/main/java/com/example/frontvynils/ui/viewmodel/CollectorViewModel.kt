package com.example.frontvynils.ui.viewmodel

import androidx.compose.runtime.*
import androidx.lifecycle.*
import com.example.frontvynils.models.Collector
import com.example.frontvynils.repository.ICollectorRepository
import kotlinx.coroutines.*

class CollectorViewModel(private val repository: ICollectorRepository, id: Int) : ViewModel() {
    private val _collector = mutableStateOf<Collector?>(null)
    private val _isLoading = mutableStateOf(true)

    val collector: State<Collector?> = _collector
    val isLoading: State<Boolean> = _isLoading

    init {
        reload(id)
    }

    fun reload(id: Int) {
        if (_collector.value != null && _collector.value!!.id == id) {
            return
        }

        viewModelScope.launch {
            _isLoading.value = true
            try {
                _collector.value = repository.getCollector(id = id)
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                delay(100)
                _isLoading.value = false
            }
        }
    }
}