package com.example.frontvynils.ui.composables

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

import com.example.frontvynils.models.Album
import com.example.frontvynils.ui.viewmodel.AlbumViewModel

@Composable
fun AlbumList(albumViewModel: AlbumViewModel) {
    val albums = albumViewModel.albums.value
    LazyColumn {
        items(albums) { album ->
            ListItem(album)
        }
    }
}

@Composable
fun ListItem(album: Album) {
    Text(text = album.name, style = MaterialTheme.typography.bodyMedium)
}
