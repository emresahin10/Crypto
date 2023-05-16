package com.emresahin.crypto.authentication.login

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val loginRoute = "login"

fun NavGraphBuilder.loginScreen(
    onNavigateToMarkets: () -> Unit
) = composable(
    route = loginRoute,
) {
    val viewModel: LoginViewModel = hiltViewModel()
    val state by viewModel.viewState.collectAsState()

    LoginScreen(
        state = state,
        onLogin = viewModel::login,
        onMailChange = viewModel::onMailChange,
        onPasswordChange = viewModel::onPasswordChange,
        onUIEventHandled = viewModel::onUIEventHandled,
        onNavigateToMarkets = onNavigateToMarkets,
    )
}

fun NavController.navigateToLogin() {
    navigate(loginRoute)
}