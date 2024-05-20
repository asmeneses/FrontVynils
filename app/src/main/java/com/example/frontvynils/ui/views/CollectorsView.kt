package com.example.frontvynils.ui.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.frontvynils.models.Collector
import com.example.frontvynils.ui.viewmodel.CollectorsViewModel

@Composable
fun CollectorsView(collectorsViewModel: CollectorsViewModel) {
    val collectors = collectorsViewModel.collectors.value

    LazyVerticalGrid(
        columns = GridCells.Fixed(1),
        contentPadding = PaddingValues(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.padding(top = 70.dp, bottom = 75.dp)
    ) {
        items(collectors) { collector ->
            CollectorItem(collector)
        }
    }
}

@Composable
fun CollectorItem(collector: Collector) {
    Surface(
        color = Color.LightGray,
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = collector.name,
                fontSize = 20.sp,
                color = Color.Black,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            )
        }
    }
}