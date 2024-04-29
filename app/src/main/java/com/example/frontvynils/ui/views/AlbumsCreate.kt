import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.example.frontvynils.models.Album
import com.example.frontvynils.ui.viewmodel.AlbumCreateModel
import java.util.*

@Composable
fun AlbumsCreate(albumCreateModel: AlbumCreateModel) {
    // Estados para los campos del álbum
    val nameState = remember { mutableStateOf("") }
    val coverState = remember { mutableStateOf("") }
    val releaseDateState = remember { mutableStateOf("") }
    val descriptionState = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Campo de entrada para el nombre del álbum
        TextField(
            value = nameState.value,
            onValueChange = { nameState.value = it },
            label = { Text("Nombre del álbum") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
            keyboardActions = KeyboardActions(
                onNext = { /* Pasar al siguiente campo */ }
            )
        )

        // Campo de entrada para la ruta de la portada
        TextField(
            value = coverState.value,
            onValueChange = { coverState.value = it },
            label = { Text("Ruta de la portada") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
            keyboardActions = KeyboardActions(
                onNext = { /* Pasar al siguiente campo */ }
            )
        )

        // Campo de entrada para la fecha de lanzamiento
        TextField(
            value = releaseDateState.value,
            onValueChange = { releaseDateState.value = it },
            label = { Text("Fecha de lanzamiento (yyyy-mm-dd)") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
            keyboardActions = KeyboardActions(
                onNext = { /* Pasar al siguiente campo */ }
            )
        )

        // Campo de entrada para la descripción del álbum
        TextField(
            value = descriptionState.value,
            onValueChange = { descriptionState.value = it },
            label = { Text("Descripción") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions(
                onDone = { /* Ocultar el teclado */ }
            )
        )

        // Botón para agregar el álbum
        Button(
            onClick = {
                // Crear una instancia de la clase Album con los datos ingresados por el usuario
                val album = Album(
                    id = 0, // Este valor se puede reemplazar con el ID real si se obtiene del backend
                    name = nameState.value,
                    cover = coverState.value,
                    releaseData = Date(releaseDateState.value),
                    description = descriptionState.value,
                    // Aquí puedes establecer el género y el sello discográfico como desees
                    genre = Album.Genre.ROCK,
                    recordLabel = Album.RecordLabel.SONY
                )

                // Llamar al método en el ViewModel para agregar el álbum
                albumCreateModel.addAlbum(album)

                // Limpiar los campos después de agregar el álbum
                nameState.value = ""
                coverState.value = ""
                releaseDateState.value = ""
                descriptionState.value = ""
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Agregar Álbum")
        }
    }
}
