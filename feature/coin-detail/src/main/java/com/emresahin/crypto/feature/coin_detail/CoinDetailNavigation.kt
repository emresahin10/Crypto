package com.emresahin.crypto.feature.coin_detail

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

const val coinDetailRoute = "coinDetail"
const val markets = "markets"
const val coinDetailQuery = "coinId"
const val coinDetailPath = "ids"
const val vsCurrencyQuery = "usd"
const val vsCurrencyPath = "vs_currency"

private fun coinDetailRoute(): String {
    return "$markets?$vsCurrencyQuery={$vsCurrencyPath}&$coinDetailPath={$coinDetailQuery}"
}

fun coinDetailRoute(vsCurrency: String = "usd", coinId: String): String {
    return "$markets?$vsCurrencyPath=$vsCurrency&$coinDetailPath=$coinId"
}

internal class CoinDetailArgs(val vsCurrency: String, val coinId: String) {
    constructor(savedStateHandle: SavedStateHandle) : this(
        vsCurrency = checkNotNull(savedStateHandle[vsCurrencyQuery]) as String,
        coinId = checkNotNull(savedStateHandle[coinDetailQuery]) as String,
    )
}

fun NavGraphBuilder.coinDetailScreen(
    onNavigateBack: () -> Unit,
) = composable(
    route = coinDetailRoute(),
    arguments = listOf(
        navArgument(vsCurrencyQuery) {
            this.defaultValue = "usd"
            type = NavType.StringType
        },
        navArgument(coinDetailQuery) {
            type = NavType.StringType
        }
    )
) {
    val viewModel: CoinDetailViewModel = hiltViewModel()
    val state by viewModel.viewState.collectAsState()

    CoinDetailScreen(
        state = state,
        onUIEventHandled = viewModel::onUIEventHandled,
        onSaveToMyCoins = viewModel::onSaveToMyCoins,
        onNavigateBack = onNavigateBack,
    )
}

fun NavController.navigateToCoinDetail(vsCurrency: String, coinId: String) {
    this.navigate(coinDetailRoute(vsCurrency = vsCurrency, coinId = coinId))
}