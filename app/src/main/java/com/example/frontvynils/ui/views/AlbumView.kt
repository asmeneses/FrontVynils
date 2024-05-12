package com.example.frontvynils.ui.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.frontvynils.ui.theme.AlbumsPrimaryColor
import com.example.frontvynils.ui.theme.MainColor
import com.example.frontvynils.ui.viewmodel.AlbumViewModel

@Composable
fun AlbumView(navController: NavController, albumViewModel: AlbumViewModel) {
    val album = albumViewModel.album.value
    val isLoading = albumViewModel.isLoading.value

    var scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .background(color = MainColor)
            .fillMaxWidth()
            .fillMaxHeight()
            .verticalScroll(scrollState)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            Arrangement.Center,
        ) {
            Box(
                modifier = Modifier
                    .background(
                        color = Color(217, 217, 217),
                        shape = RoundedCornerShape(50.dp)
                    )
                    .defaultMinSize(
                        minWidth = ButtonDefaults.MinWidth,
                        minHeight = ButtonDefaults.MinHeight
                    )
            ) {
                Text(
                    text = "Detalle Album",
                    fontSize = TextUnit(value = 18f, type = TextUnitType.Sp),
                    modifier = Modifier
                        .padding(ButtonDefaults.ContentPadding)
                        .align(alignment = Alignment.Center)
                )
            }
        }

        if (isLoading) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                Arrangement.Center,
            ) {
                CircularProgressIndicator()
            }
        } else {
            album?.let {
                var day   = it.releaseDate.slice(IntRange(8, 9))
                var month = it.releaseDate.slice(IntRange(5, 6))
                var year  = it.releaseDate.slice(IntRange(0, 3))

                DoubleText(leftText = "Nombre", rightText = it.name)
                DoubleText(leftText = "Fecha Grabación", rightText = year)
                DoubleText(leftText = "Fecha Lanzamiento", rightText = "${day}-${month}-${year}")
                DoubleText(leftText = "Género", rightText = it.genre)
                DoubleText(leftText = "Productor", rightText = it.recordLabel)

                Row(modifier = Modifier.padding(vertical = 10.dp)) {
                    Column(
                        modifier = Modifier
                            .padding(horizontal = 5.dp)
                            .weight(1F),
                        horizontalAlignment = Alignment.End
                    ) {
                        Text(
                            color = Color(0XFFD0C0A7),
                            fontSize = TextUnit(value = 20f, type = TextUnitType.Sp),
                            fontWeight = FontWeight.ExtraBold,
                            text = album.name,
                            overflow = TextOverflow.Clip,
                            softWrap = false
                        )
                    }

                    Column(
                        modifier = Modifier
                            .padding(horizontal = 5.dp)
                            .weight(1F),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ){
                        AsyncImage(
                            model = album.cover,
                            contentDescription = album.name,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .heightIn(min = 140.dp, max = 140.dp)
                                .widthIn(min = 140.dp, max = 140.dp)
                        )
                    }
                }
            }
        }

        // Back button
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            Arrangement.Center,
        ) {
            Button(
                onClick = {
                    navController.navigate("albums")
                },
                colors = ButtonColors(
                    containerColor = AlbumsPrimaryColor,
                    contentColor = Color.White,
                    disabledContentColor = Color.Black,
                    disabledContainerColor = Color.Black
                )
            ) {
                Text(
                    color = Color.White,
                    fontSize = TextUnit(value = 18f, type = TextUnitType.Sp),
                    text = "Volver",
                )
            }
        }

        Spacer(modifier = Modifier.height(60.dp))
    }
}

@Composable
fun DoubleText(leftText: String, rightText: String) {
    Row(modifier = Modifier.padding(vertical = 10.dp)) {
        Column(
            modifier = Modifier
                .padding(horizontal = 5.dp)
                .weight(1F),
            horizontalAlignment = Alignment.End
        ) {
            Text(
                color = Color(0XFFD0C0A7),
                fontSize = TextUnit(value = 20F, type = TextUnitType.Sp),
                fontWeight = FontWeight.ExtraBold,
                text = leftText,
                overflow = TextOverflow.Clip
            )
        }

        Column(
            modifier = Modifier.weight(1F),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                fontSize = TextUnit(value = 20f, type = TextUnitType.Sp),
                fontWeight = FontWeight.ExtraBold,
                text = rightText,
                overflow = TextOverflow.Clip
            )
        }
    }
}