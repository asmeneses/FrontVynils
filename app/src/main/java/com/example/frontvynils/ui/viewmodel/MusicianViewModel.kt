package com.example.frontvynils.ui.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.frontvynils.models.Musician
import com.example.frontvynils.repository.IMusicianRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MusicianViewModel(private val repository: IMusicianRepository, id: Int) : ViewModel() {
    private val _musician = mutableStateOf<Musician?>(null)
    private val _isLoading = mutableStateOf(true)

    val album: State<Musician?> = _musician
    val isLoading: State<Boolean> = _isLoading

    init {
        reload(id)
    }

    fun reload(id: Int) {
        if (_musician.value != null && _musician.value!!.id == id) {
            return
        }

        viewModelScope.launch {
            _isLoading.value = true
            try {
                _musician.value = repository.getMusician(id = id)
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                delay(100)
                _isLoading.value = false
            }
        }
    }
}