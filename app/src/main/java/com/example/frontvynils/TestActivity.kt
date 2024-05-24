package com.example.frontvynils

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.frontvynils.repository.AlbumRepositoryMock
import com.example.frontvynils.repository.CollectorRepositoryMock
import com.example.frontvynils.repository.MusicianRepositoryMock
import com.example.frontvynils.ui.navigation.MainScreen

class TestActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen(
                albumRepository = AlbumRepositoryMock(),
                collectorRepository = CollectorRepositoryMock(),
                musicianRepository = MusicianRepositoryMock()
            )
        }
    }
}