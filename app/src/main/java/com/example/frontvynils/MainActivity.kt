package com.example.frontvynils

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.frontvynils.ui.composables.AlbumList

import com.example.frontvynils.ui.theme.FrontVynilsTheme
import com.example.frontvynils.ui.viewmodel.AlbumViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MyApp() {
    FrontVynilsTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            var albumViewModel: AlbumViewModel = AlbumViewModel()
            AlbumList(albumViewModel = albumViewModel)
        }
    }
}

// @Composable
// fun MyApp(content: @Composable () -> Unit) {
//     MaterialTheme {
//         Surface {
//             content()
//         }
//     }
// }

// class MainActivity : ComponentActivity() {
//     override fun onCreate(savedInstanceState: Bundle?) {
//         super.onCreate(savedInstanceState)
//         setContent {
//             FrontVynilsTheme {
//                 // A surface container using the 'background' color from the theme
//                 Surface(
//                     modifier = Modifier.fillMaxSize(),
//                     color = MaterialTheme.colorScheme.background
//                     content()
//                 ) {
//                     Greeting("Hello")
//                 }
//             }
//         }
//     }
// }

// @Composable
// fun Greeting(name: String, modifier: Modifier = Modifier) {
//     Text(
//         text = "Hello $name!",
//         modifier = modifier
//     )
// }

// @Preview(showBackground = true)
// @Composable
// fun GreetingPreview() {
//     FrontVynilsTheme {
//         Greeting("Android")
//     }
// }