package com.example.frontvynils.ui.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

import com.example.frontvynils.models.Album
import com.example.frontvynils.network.RetrofitInstance
import com.example.frontvynils.repository.AlbumRepository

class AlbumCreateModel : ViewModel() {
    private val repository = AlbumRepository(RetrofitInstance.api)

    var albums = mutableStateOf<List<Album>>(listOf())
        private set

    init {
        viewModelScope.launch {
            albums.value = repository.getAlbums()
        }
    }
}
