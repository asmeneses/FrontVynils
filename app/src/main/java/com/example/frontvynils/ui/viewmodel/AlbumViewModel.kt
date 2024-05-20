package com.example.frontvynils.ui.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.frontvynils.models.Album
import com.example.frontvynils.repository.IAlbumRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class AlbumViewModel(private val repository: IAlbumRepository, id: Int) : ViewModel() {
    private val _album = mutableStateOf<Album?>(null)
    private val _isLoading = mutableStateOf(true)

    val album: State<Album?> = _album
    val isLoading: State<Boolean> = _isLoading

    init {
        reload(id)
    }

    fun reload(id: Int) {
        if (_album.value != null && _album.value!!.id == id) {
            return
        }

        viewModelScope.launch {
            _isLoading.value = true
            try {
                _album.value = repository.getAlbum(albumId = id)
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                delay(100)
                _isLoading.value = false
            }
        }
    }
}