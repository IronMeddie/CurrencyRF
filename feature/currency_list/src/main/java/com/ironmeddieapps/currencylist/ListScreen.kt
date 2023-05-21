package com.ironmeddieapps.currencylist

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ironmeddieapps.models.CurencyItem
import com.ironmeddieapps.utils.DataResource

@Composable
fun ListScreen(viewModel: ListViewModel = hiltViewModel()) {

    val data = viewModel.list.collectAsState().value

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        when (data) {
            is DataResource.Success -> {
                items(data.data.Valute, key = { it.ID }) {
                    ListItem(it){
                        viewModel.saveValute(it)
                    }
                }
            }

            is DataResource.Failure -> {
                item {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        Text(text = data.errorBody)
                    }
                }

            }

            else -> {
                item {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        CircularProgressIndicator()
                    }
                }
            }
        }


    }

}

@Composable
private fun ListItem(item: CurencyItem, onClickFavorite : ()-> Unit) {
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
        IconButton(onClick = {onClickFavorite()}, modifier = Modifier.align(Alignment.CenterEnd)) {
            Icon(imageVector = Icons.Default.Favorite, contentDescription = "save valute")
        }
    }


}