package com.example.frontvynils.ui.views

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign

import com.example.frontvynils.models.Album
import com.example.frontvynils.ui.viewmodel.AlbumViewModel

@Composable
fun AlbumsView(albumViewModel: AlbumViewModel) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Albums",
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            color = Color.White,
            style = MaterialTheme.typography.headlineLarge
        )
    }

    return;

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
