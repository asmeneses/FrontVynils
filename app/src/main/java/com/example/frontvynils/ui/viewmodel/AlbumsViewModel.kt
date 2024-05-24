package com.example.frontvynils.ui.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.frontvynils.models.Album
import com.example.frontvynils.repository.IAlbumRepository
import kotlinx.coroutines.launch

class AlbumsViewModel(private val repository : IAlbumRepository) : ViewModel() {
    var albums = mutableStateOf<List<Album>>(listOf())
    private set

    init {
        reload()
    }

    fun reload() {
        viewModelScope.launch {
            albums.value = repository.getAlbums()
        }
    }
}
