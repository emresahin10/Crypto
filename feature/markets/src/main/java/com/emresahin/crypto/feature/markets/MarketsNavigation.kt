package com.emresahin.crypto.feature.markets

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable

const val marketsRoute = "markets"

fun NavGraphBuilder.marketsScreen(
    onNavigateToCoinDetail: (vsCurrency: String, coinId: String) -> Unit,
) = composable(
    route = marketsRoute,
) {
    val viewModel: MarketsViewModel = hiltViewModel()
    val state by viewModel.viewState.collectAsState()

    MarketsScreen(
        state = state,
        onNavigateToCoinDetail = onNavigateToCoinDetail,
        onUIEventHandled = viewModel::onUIEventHandled
    )
}

fun NavController.navigateToMarkets(options: NavOptions) {
    this.navigate(route = marketsRoute, navOptions = options)
}