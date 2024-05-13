package com.example.frontvynils.ui.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.frontvynils.models.Album
import com.example.frontvynils.repository.IAlbumRepository
import kotlinx.coroutines.launch

class AlbumCreateViewModel(private val repository: IAlbumRepository) : ViewModel() {
    private val _album = mutableStateOf<Album?>(null)
    private val _isSaving = mutableStateOf(false)
    private val _hasSave = mutableStateOf(false)

    var album: State<Album?> = _album
    var isSaving: State<Boolean> = _isSaving
    var hasSave: State<Boolean> = _hasSave

    fun save(album: Album) {
        viewModelScope.launch {
            _album.value = null
            _isSaving.value = true
            _hasSave.value = false

            try {
                _album.value = repository.createAlbum(album)
                _hasSave.value = _album.value != null
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                _isSaving.value = false
            }
        }
    }
}