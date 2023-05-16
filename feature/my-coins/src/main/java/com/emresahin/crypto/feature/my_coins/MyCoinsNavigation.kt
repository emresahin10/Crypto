package com.emresahin.crypto.feature.my_coins

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable

const val myCoinsRoute = "myCoins"

fun NavGraphBuilder.myCoinsScreen(
) = composable(
    route = myCoinsRoute,
) {
    val viewModel: MyCoinsViewModel = hiltViewModel()
    val state by viewModel.viewState.collectAsState()

    MyCoinsScreen(
        state = state,
        onUIEventHandled = viewModel::onUIEventHandled
    )
}

fun NavController.navigateToMyCoins(options: NavOptions) {
    this.navigate(route = myCoinsRoute, navOptions = options)
}