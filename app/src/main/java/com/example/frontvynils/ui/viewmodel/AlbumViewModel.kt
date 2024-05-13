package com.example.frontvynils.ui.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.frontvynils.models.Album
import com.example.frontvynils.repository.IAlbumRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class AlbumViewModel(private val repository: IAlbumRepository, albumId: Int) : ViewModel() {
    private val _album = mutableStateOf<Album?>(null)
    private val _isLoading = mutableStateOf(true)

    val album: State<Album?> = _album
    val isLoading: State<Boolean> = _isLoading

    init {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                _album.value = repository.getAlbum(albumId = albumId)
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                delay(100)
                _isLoading.value = false
            }
        }
    }
}