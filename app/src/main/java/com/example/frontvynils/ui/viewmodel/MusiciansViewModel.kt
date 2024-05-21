package com.example.frontvynils.ui.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.frontvynils.models.Musician
import com.example.frontvynils.repository.IMusicianRepository
import kotlinx.coroutines.launch

class MusiciansViewModel(private val repository : IMusicianRepository) : ViewModel() {
    var musicians = mutableStateOf<List<Musician>>(listOf())
    private set

    init {
        viewModelScope.launch {
            musicians.value = repository.getMusicians()
        }
    }
}
