package com.ironmeddieapps.main_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ironmeddieapps.navigation.navigateToList
import com.ironmeddieapps.utils.DataResource


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(viewModel: MainScreenViewModel = hiltViewModel(), navController: NavController) {
    val data = viewModel.list.collectAsState().value

    Scaffold(
        topBar = {
            Row(horizontalArrangement = Arrangement.End, modifier = Modifier.fillMaxWidth()) {
                IconButton(onClick = { navController.navigateToList() }) {

                    Icon(imageVector = Icons.Default.Add, contentDescription = "add valutes")
                }
            }
        }
    ) {
        LazyColumn(modifier = Modifier.padding(it)){

            when (data ){
                is DataResource.Success -> {
                    item(key = "infoBanner") {
                        InfoBanner(data.data)
                    }
                    items(data.data.Valute, key = { it.ID }){
                        ListItem(item = it) {
                        }
                    }
                }
                is DataResource.Failure ->{
                    item {
                        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                            Text(text = data.errorBody)
                        }
                    }
                }
                is DataResource.Loading ->{
                    item {
                        CircularProgressIndicator()
                    }

                }
            }

        }
    }


}