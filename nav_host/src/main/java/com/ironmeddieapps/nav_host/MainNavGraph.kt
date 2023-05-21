package com.ironmeddieapps.nav_host

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ironmeddieapps.currencylist.ListScreen
import com.ironmeddieapps.currencylist.ListViewModel
import com.ironmeddieapps.main_screen.MainScreen
import com.ironmeddieapps.main_screen.MainScreenViewModel
import com.ironmeddieapps.navigation.Screens



@Composable
fun MainNavGraph(){

    val navController= rememberNavController()

    NavHost(navController = navController, startDestination = Screens.MAIN_SCREEN_ROUTE, modifier = Modifier.fillMaxSize()){
        composable(Screens.MAIN_SCREEN_ROUTE){
            val viewModel : MainScreenViewModel = hiltViewModel()
            MainScreen(navController = navController, viewModel = viewModel)
        }

        composable(Screens.LIST_SCREEN_ROUTE){
            val viewModel : ListViewModel = hiltViewModel()
            ListScreen(viewModel = viewModel)
        }
    }
}