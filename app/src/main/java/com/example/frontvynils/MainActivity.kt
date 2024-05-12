package com.example.frontvynils

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.frontvynils.network.RetrofitInstance
import com.example.frontvynils.repository.AlbumRepository
import com.example.frontvynils.ui.navigation.MainScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen(
                albumRepository = AlbumRepository(RetrofitInstance.api)
            )
        }
    }
}