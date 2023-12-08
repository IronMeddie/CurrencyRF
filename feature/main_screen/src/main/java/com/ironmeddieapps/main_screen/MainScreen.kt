package com.ironmeddieapps.main_screen


import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
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
import androidx.navigation.NavController
import com.ironmeddieapps.navigation.navigateToList
import com.ironmeddieapps.utils.DataResource


@OptIn(ExperimentalMaterialApi::class, ExperimentalFoundationApi::class)
@Composable
fun MainScreen(viewModel: MainScreenViewModel = hiltViewModel(), navController: NavController) {
    val data = viewModel.list.collectAsState().value
    val refreshing = data is DataResource.Loading
    val state = rememberPullRefreshState(refreshing, viewModel::getList)

    Scaffold(
        topBar = {
            Box( modifier = Modifier.fillMaxWidth()) {
                if (data is DataResource.Success)Text(text = convertDate(data.data.Date), modifier = Modifier.align(
                    Alignment.CenterStart))
                IconButton(onClick = { navController.navigateToList() }, modifier = Modifier.align(
                    Alignment.CenterEnd)) {
                    Icon(imageVector = Icons.Default.Add, contentDescription = "add valutes")
                }
            }
        }
    ) {

        Box(
            Modifier
                .fillMaxSize()
                .pullRefresh(state)
        ) {
            LazyColumn(
                modifier = Modifier
                    .padding(it)
                    .fillMaxSize()
            ) {

                when (data) {
                    is DataResource.Success -> {
                        items(data.data.Valute, key = { it.ID }) {
                            ListItem(item = it, Modifier
                                .fillMaxWidth()
                                .padding(4.dp)
                                .shadow(4.dp, RoundedCornerShape(16.dp))
                                .background(Color.White)
                                .clip(RoundedCornerShape(16.dp))
                                .animateItemPlacement()) {
                                viewModel.deleteValute(it)
                            }
                        }
                    }

                    is DataResource.Failure -> {
                        item {
                            Box(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .animateItemPlacement(),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(text = data.errorBody)
                            }
                        }
                    }

                    is DataResource.Loading -> {

                    }
                }

            }
            PullRefreshIndicator(refreshing, state, Modifier.align(Alignment.TopCenter))
        }
    }


}