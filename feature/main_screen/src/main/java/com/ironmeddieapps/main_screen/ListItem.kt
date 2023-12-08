package com.ironmeddieapps.main_screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.ironmeddieapps.models.CurencyItem


@Composable
fun ListItem(item: CurencyItem, modifier: Modifier , onClickDelete: () -> Unit) {
    Box(modifier= modifier) {
        Column(



        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp, vertical = 8.dp)
            ) {
                Text(
                    text = item.Name,
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.fillMaxWidth(0.7f)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(text = item.CharCode, style = MaterialTheme.typography.titleMedium)
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp, vertical = 8.dp)
            ) {
                val raznitsa = item.Value - item.Previous
                Text(text = item.Value.toString(), style = MaterialTheme.typography.headlineLarge)
                val color = if (raznitsa >= 0) Color.Green else Color.Red
                val icon =
                    if (raznitsa >= 0) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown
                Spacer(modifier = Modifier.width(16.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(imageVector = icon, contentDescription = "arrow", tint = color)

                    Text(
                        text = String.format("%.2f", raznitsa),
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }


        }

        IconButton(onClick = onClickDelete, modifier = Modifier.align(Alignment.BottomEnd)) {
            Icon(imageVector = Icons.Default.Delete, contentDescription = "delete")
        }

    }

}