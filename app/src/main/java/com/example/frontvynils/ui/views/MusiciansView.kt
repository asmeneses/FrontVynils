package com.example.frontvynils.ui.views

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.frontvynils.ui.viewmodel.MusiciansViewModel

@Composable
fun MusiciansView(navController: NavController, musiciansViewModel: MusiciansViewModel) {
    val musicians = musiciansViewModel.musicians.value

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.padding(top = 70.dp, bottom = 75.dp)
    ) {
        items(musicians) { musician ->
            GridItem1(
                musician.name,
                musician.image,
                onClick = {
                    // TODO: Navigate to "artists/${musician.id!!}"
                }
            )
        }
    }
}

@Composable
fun GridItem1(name: String, image: String, onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .padding(10.dp)
            .width(150.dp)
            .clickable(onClick = onClick)
    ) {
        AsyncImage(
            model = image,
            contentDescription = name,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .heightIn(min = 150.dp, max = 150.dp)
        )

        Text(
            text = name,
            fontSize = 18.sp,
            color = Color.White,
            textAlign = TextAlign.Center,
            overflow = TextOverflow.Ellipsis,
            softWrap = false,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 2.dp)
        )
    }
}
