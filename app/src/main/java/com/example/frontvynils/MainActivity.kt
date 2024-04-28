package com.example.frontvynils

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.frontvynils.ui.navigation.MainScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}

// @Preview(showBackground = true)
// @Composable
// fun MyApp() {
//     FrontVynilsTheme {
//         // A surface container using the 'background' color from the theme
//         Surface(
//             modifier = Modifier.fillMaxSize(),
//             color = MaterialTheme.colorScheme.background
//         ) {
//             var albumViewModel: AlbumViewModel = AlbumViewModel()
//             AlbumsView(albumViewModel = albumViewModel)
//         }
//     }
// }