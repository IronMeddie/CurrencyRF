package com.ironmeddieapps.main_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.ironmeddieapps.models.CurencyItem


@Composable
fun ListItem(item: CurencyItem, onClickFavorite : ()-> Unit) {
    Box() {
        Column(
            Modifier
                .fillMaxWidth()
                .padding(4.dp)
                .shadow(4.dp, RoundedCornerShape(16.dp))
                .background(Color.White)
                .clip(RoundedCornerShape(16.dp))

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
                Text(text = "Сегодня: ", style = MaterialTheme.typography.bodyMedium)
                Text(text = item.Value.toString(), style = MaterialTheme.typography.bodyMedium)
                Spacer(modifier = Modifier.width(16.dp))
                Text(text = "Ранее: ", style = MaterialTheme.typography.bodyMedium)
                Text(text = item.Previous.toString(), style = MaterialTheme.typography.bodyMedium)
            }

        }

    }

}