package com.example.frontvynils.ui.navigation

import android.annotation.SuppressLint
import androidx.compose.animation.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.*
import androidx.compose.material.icons.rounded.*
import androidx.compose.material3.Button
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTag
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.*
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.*
import androidx.navigation.navArgument
import com.example.frontvynils.repository.*
import com.example.frontvynils.ui.theme.*
import com.example.frontvynils.ui.viewmodel.*
import com.example.frontvynils.ui.views.*

var albumViewModel: AlbumViewModel? = null
var albumsViewModel: AlbumsViewModel? = null

var collectorViewModel: CollectorViewModel? = null
var collectorsViewModel: CollectorsViewModel? = null

var musicianViewModel: MusicianViewModel? = null
var musiciansViewModel: MusiciansViewModel? = null

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen(
    albumRepository: IAlbumRepository,
    collectorRepository: ICollectorRepository,
    musicianRepository: IMusicianRepository
) {
    val navController = rememberNavController()
    var viewIndex = 1

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
                onClick = {
                    when (viewIndex) {
                        1 -> navController.navigate("addAlbum")
                    }
                },
                colors = MainButtonColors
            ) {
                Icon(Icons.Rounded.Add, contentDescription = "")
            }
        }

        NavHost(navController, startDestination = "albums") {
            composable(route = "albums") {
                viewIndex = 1
                if (albumsViewModel == null) {
                    albumsViewModel = AlbumsViewModel(albumRepository)
                }

                AlbumsView(navController, albumsViewModel = albumsViewModel!!)
            }

            composable(
                route = "albums/{id}",
                arguments = listOf(navArgument("id") { type = NavType.IntType })
            ) { it ->
                var id = it.arguments?.getInt("id")!!

                if (albumViewModel == null) {
                    albumViewModel = AlbumViewModel(albumRepository, id)
                }

                AlbumView(navController = navController, id = id, albumViewModel = albumViewModel!!)
            }

            composable(route = "addAlbum") {
                AlbumCreateView(
                    navController = navController,
                    model = AlbumCreateViewModel(albumRepository)
                )
            }

            composable(route = "artists") {
                viewIndex = 1
                if (musiciansViewModel == null) {
                    musiciansViewModel = MusiciansViewModel(musicianRepository)
                }

                MusiciansView(navController, musiciansViewModel = musiciansViewModel!!)
            }

            composable(
                route = "artists/{id}",
                arguments = listOf(navArgument("id") { type = NavType.IntType })
            ) { it ->
                var id = it.arguments?.getInt("id")!!

                if (musicianViewModel == null) {
                    musicianViewModel = MusicianViewModel(musicianRepository, id)
                }

                // TODO: Create Musician View
            }

            composable("collectors") {
                viewIndex = 3

                if (collectorsViewModel == null) {
                    collectorsViewModel = CollectorsViewModel(collectorRepository)
                }

                CollectorsView(
                    navController = navController,
                    collectorsViewModel = collectorsViewModel!!
                )
            }
            
            composable(
                route = "collectors/{id}",
                arguments = listOf(navArgument("id") { type = NavType.IntType })
            ) {
                var id = it.arguments?.getInt("id")!!
                
                if (collectorViewModel == null) {
                    collectorViewModel = CollectorViewModel(collectorRepository, id)
                }
                
                CollectorView(navController = navController, id = id, collectorViewModel = collectorViewModel!!)
            }

            composable("songs") {
                viewIndex = 4
                SongsView()
            }
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
            .background(
                color = if (isSelected) MainColor else Color.White,
                shape = RoundedCornerShape(percent = 50)
            )
            .clickable(onClick = onClick)
            .semantics { testTag = text },
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