package com.emresahin.crypto.feature.search

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable

const val searchRoute = "search"

fun NavGraphBuilder.searchScreen(
    onNavigateToCoinDetail: (vsCurrency: String, coinId: String) -> Unit,
) = composable(
    route = searchRoute,
) {
    val viewModel: SearchViewModel = hiltViewModel()
    val state by viewModel.viewState.collectAsState()

    SearchScreen(
        state = state,
        fetchSearchResults = viewModel::fetchSearchResults,
        onQueryChange = viewModel::onQueryChange,
        clearText = viewModel::clearText,
        onNavigateToCoinDetail = onNavigateToCoinDetail,
        onUIEventHandled = viewModel::onUIEventHandled,
    )
}

fun NavController.navigateToSearch(options: NavOptions) {
    this.navigate(route = searchRoute, navOptions = options)
}
