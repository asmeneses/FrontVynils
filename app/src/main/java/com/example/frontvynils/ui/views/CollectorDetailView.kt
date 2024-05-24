package com.example.frontvynils.ui.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.*
import androidx.navigation.NavController
import com.example.frontvynils.ui.theme.*
import com.example.frontvynils.ui.viewmodel.CollectorViewModel

@Composable
fun CollectorView(navController: NavController, id: Int, collectorViewModel: CollectorViewModel) {
    collectorViewModel.reload(id)

    val collector = collectorViewModel.collector.value
    val isLoading = collectorViewModel.isLoading.value

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
            collector?.let {
                DoubleText(leftText = "Nombre", rightText = it.name)
                DoubleText(leftText = "Telefono", rightText = it.telephone)
                DoubleText(leftText = "email", rightText = it.email)
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
                    navController.navigate("collectors")
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