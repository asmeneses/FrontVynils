package com.example.frontvynils.ui.views

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.frontvynils.models.Album
import com.example.frontvynils.ui.theme.AlbumsPrimaryColor
import com.example.frontvynils.ui.theme.MainColor
import com.example.frontvynils.ui.theme.textFieldColor
import com.example.frontvynils.ui.viewmodel.AlbumCreateViewModel

@Composable
fun AlbumCreateView(navController: NavController, model: AlbumCreateViewModel) {
    val album = model.album.value
    val isSaving = model.isSaving.value
    val hasSave = model.hasSave.value

    var scrollState = rememberScrollState()
    val focusManager = LocalFocusManager.current

    val albumNameState = remember { mutableStateOf(TextFieldValue()) }
    val recordDateState = remember { mutableStateOf(TextFieldValue()) }
    val launchDateState = remember { mutableStateOf(TextFieldValue()) }
    val genreState = remember { mutableStateOf(String()) }
    val recordLabelState = remember { mutableStateOf(String()) }
    val coverState = remember { mutableStateOf(TextFieldValue()) }

    Column(
        modifier = Modifier
            .background(color = MainColor)
            .fillMaxWidth()
            .fillMaxHeight()
            .pointerInput(Unit) {
                detectTapGestures(
                    onPress = { },
                    onTap = { focusManager.clearFocus() }
                )
            }
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
                    text = "Agregar Album",
                    fontSize = TextUnit(value = 18f, type = TextUnitType.Sp),
                    modifier = Modifier
                        .padding(ButtonDefaults.ContentPadding)
                        .align(alignment = Alignment.Center)
                )
            }
        }

        InputText(fieldName = "Artista", label = "Ingrese el nombre del artista", textFieldValue = albumNameState)
        InputText(fieldName = "Fecha Grabación", label = "Ingrese la fecha de grabación", textFieldValue = recordDateState)
        InputText(fieldName = "Fecha Lanzamiento", label = "Ingrese la fecha de lanzamiento", textFieldValue = launchDateState)
        InputDropdown(fieldName = "Productor", label = "Seleccione el productor", options = listOf("Sony Music", "EMI", "Discos Fuentes", "Elektra", "Fania Records"), selectedOption = recordLabelState)
        InputDropdown(fieldName = "Género", label = "Seleccione el género", options = listOf("Classical", "Salsa", "Rock", "Folk"), selectedOption = genreState)
        InputText(fieldName = "Carátula", label = "Ingrese el enlace a la carátula", textFieldValue = coverState)

        if (album != null) {
            navController.navigate("albums")
        } else if (isSaving) {
            CircularProgressIndicator()
        } else
        {
            // Back button
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                Arrangement.Center,
            ) {
                Button(
                    onClick = {
                        model.save(
                            album = Album(
                                name = albumNameState.value.text,
                                cover = coverState.value.text,
                                releaseDate = launchDateState.value.text,
                                description = "No description",
                                genre = genreState.value,
                                recordLabel = recordLabelState.value
                            )
                        )
                    },
                    colors = ButtonColors(
                        containerColor = AlbumsPrimaryColor,
                        contentColor = Color.White,
                        disabledContentColor = Color.Black,
                        disabledContainerColor = Color.Black
                    )
                ) {
                    androidx.compose.material.Text(
                        color = Color.White,
                        fontSize = TextUnit(value = 18f, type = TextUnitType.Sp),
                        text = "Guardar",
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(60.dp))
    }
}

@Composable
fun InputText(fieldName: String, label: String, textFieldValue: MutableState<TextFieldValue>) {
    Row(modifier = Modifier.padding(vertical = 10.dp)) {
        Column(
            modifier = Modifier
                .padding(vertical = 16.5.dp, horizontal = 20.dp)
                .weight(0.7F),
            horizontalAlignment = Alignment.End
        ) {
            Text(
                color = Color(0XFFD0C0A7),
                fontSize = TextUnit(value = 20F, type = TextUnitType.Sp),
                fontWeight = FontWeight.ExtraBold,
                text = fieldName,
                textAlign = TextAlign.End,
                overflow = TextOverflow.Clip,
            )
        }

        Column(
            modifier = Modifier
                .padding(end = 10.dp)
                .weight(1F),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            TextField(
                colors = textFieldColor,
                shape = RoundedCornerShape(15.dp),
                value = textFieldValue.value,
                onValueChange = { textFieldValue.value = it },
                label = {
                    Text(
                        text = label,
                        color = Color.DarkGray,
                    )
                },
            )
        }
    }
}

@Composable
fun InputDropdown(
    fieldName: String,
    label: String,
    options: List<String>,
    selectedOption: MutableState<String>
) {
    var expanded by remember { mutableStateOf(false) }

    Row(modifier = Modifier.padding(vertical = 10.dp)) {
        Column(
            modifier = Modifier
                .padding(vertical = 16.5.dp, horizontal = 20.dp)
                .weight(0.7F),
            horizontalAlignment = Alignment.End
        ) {
            Text(
                color = Color(0XFFD0C0A7),
                fontSize = TextUnit(value = 20F, type = TextUnitType.Sp),
                fontWeight = FontWeight.ExtraBold,
                text = fieldName,
                textAlign = TextAlign.End,
                overflow = TextOverflow.Clip,
            )
        }

        Column(
            modifier = Modifier
                .padding(end = 10.dp)
                .weight(1F),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier.clickable(onClick = { expanded = true }),
                contentAlignment = Alignment.CenterStart
            ) {
                Box(
                    modifier = Modifier
                        .background(color = Color(217, 217, 217), shape = RoundedCornerShape(8.dp))
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                ) {
                    Text(
                        text = if (selectedOption.value.isEmpty()) label else selectedOption.value,
                        color = if (selectedOption.value.isEmpty()) Color.DarkGray else Color.Black
                    )
                }
                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ) {
                    options.forEach { option ->
                        DropdownMenuItem(
                            text = {
                                Text(text = option)
                            },
                            onClick = {
                                selectedOption.value = option
                                expanded = false
                            }
                        )
                    }
                }
            }
        }
    }
}

