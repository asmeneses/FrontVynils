package com.example.frontvynils.ui.navigation

import android.annotation.SuppressLint
import android.media.Image
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AddCircle
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.Dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.frontvynils.R
import com.example.frontvynils.ui.viewmodel.AlbumViewModel

import com.example.frontvynils.ui.views.AlbumsView
import com.example.frontvynils.ui.views.ArtistsView
import com.example.frontvynils.ui.views.CollectorsView
import com.example.frontvynils.ui.views.SongsView

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomNavigationBar(navController) }
    ) {
        var albumViewModel: AlbumViewModel = AlbumViewModel()

        NavHost(navController, startDestination = "albums") {
            composable("albums") { AlbumsView(albumViewModel = albumViewModel) }
            composable("artists") { ArtistsView() }
            composable("collectors") { CollectorsView() }
            composable("songs") { SongsView() }
        }
    }
}

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    val items = listOf(
        "albums" to "Albums",
        "artists" to "Artists",
        "collectors" to "Collectors",
        "songs" to "Songs"
    )
    BottomNavigation {
        items.forEach { (route, label) ->
            BottomNavigationItem(
                //icon = { Icon(ImageVector.vectorResource(id = R.drawable.icon_placeholder), contentDescription = label) },
                icon = { Icon(Icons.Rounded.AddCircle, contentDescription = label) },
                label = { Text(label) },
                selected = false,
                onClick = {
                    navController.navigate(route)
                }
            )
        }
    }
}
