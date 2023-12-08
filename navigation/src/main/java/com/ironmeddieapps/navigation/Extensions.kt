package com.ironmeddieapps.navigation

import androidx.navigation.NavController
import androidx.navigation.NavOptions


fun NavController.navigateToList(navOptions: NavOptions? = null) {
    this.navigate(Screens.LIST_SCREEN_ROUTE, navOptions)
}