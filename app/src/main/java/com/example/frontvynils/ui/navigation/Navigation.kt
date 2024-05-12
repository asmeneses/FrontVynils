package com.example.frontvynils.ui.navigation

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.AddCircle
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.frontvynils.repository.IAlbumRepository
import com.example.frontvynils.ui.theme.MainButtonColors
import com.example.frontvynils.ui.theme.MainColor
import com.example.frontvynils.ui.viewmodel.AlbumViewModel
import com.example.frontvynils.ui.viewmodel.AlbumsViewModel
import com.example.frontvynils.ui.views.AlbumView
import com.example.frontvynils.ui.views.AlbumsView
import com.example.frontvynils.ui.views.ArtistsView
import com.example.frontvynils.ui.views.CollectorsView
import com.example.frontvynils.ui.views.SongsView

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen(
    albumRepository: IAlbumRepository
) {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = { MenuBar(navController) },
        backgroundColor = MainColor
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            Arrangement.SpaceBetween,
        ) {
            Button(
                onClick = { },
                colors = MainButtonColors
            ) {
                Icon(Icons.Rounded.Search, contentDescription = "")
            }

            Button(
                onClick = { },
                colors = MainButtonColors
            ) {
                Icon(Icons.Rounded.Add, contentDescription = "")
            }
        }

        NavHost(navController, startDestination = "albums") {
            var albumsViewModel = AlbumsViewModel(albumRepository)

            composable("albums") {
                AlbumsView(navController, albumsViewModel = albumsViewModel)
            }

            composable(
                "albums/{albumId}",
                arguments = listOf(navArgument("albumId") { type = NavType.IntType })) {
                AlbumView(
                    navController = navController,
                    albumViewModel = AlbumViewModel(
                        albumRepository,
                        it.arguments?.getInt("albumId")!!
                    )
                )
            }

            composable("artists") { ArtistsView() }
            composable("collectors") { CollectorsView() }
            composable("songs") { SongsView() }
        }
    }
}

@Composable
fun MenuBar(navController: NavHostController) {
    var selectedItem by remember { mutableStateOf(0) }

    val items = listOf(
        "albums" to "Albums",
        "artists" to "Artists",
        "collectors" to "Collectors",
        "songs" to "Songs"
    )

    Box(
        modifier = Modifier.padding(20.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.White, shape = RoundedCornerShape(percent = 50))
        ) {
            items.forEachIndexed { index, (route, name) ->
                MenuItem(
                    text = name,
                    isSelected = selectedItem == index,
                    onClick = {
                        selectedItem = index
                        navController.navigate(route)
                    }
                )
            }
        }
    }
}

@Composable
fun MenuItem(text: String, isSelected: Boolean, onClick: () -> Unit) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(4.dp)
            .clickable(onClick = onClick)
            .background(
                color = if (isSelected) MainColor else Color.White,
                shape = RoundedCornerShape(percent = 50)
            ),
    ) {
        Icon(
            Icons.Rounded.AddCircle,
            contentDescription = if (isSelected) text else "",
            modifier = Modifier.padding(8.dp),
            tint = if (isSelected) Color.White else MainColor
        )

        AnimatedVisibility(
            visible = isSelected,
            enter = fadeIn() + expandHorizontally(),
            exit = fadeOut() + shrinkHorizontally()
        ) {
            Text(
                text = text,
                textAlign = TextAlign.Start,
                fontSize = TextUnit(value = 18f, type = TextUnitType.Sp),
                color = Color.White,
                modifier = Modifier.padding(end = 10.dp)
            )
        }
    }
}