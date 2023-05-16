package com.emresahin.crypto.authentication.signup

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val signUpRoute = "signup"

fun NavGraphBuilder.signUpScreen(
    onNavigateToLogin: () -> Unit,
) = composable(
    route = signUpRoute,
) {
    val viewModel: SignUpViewModel = hiltViewModel()
    val state by viewModel.viewState.collectAsState()
    SignUpScreen(
        state = state,
        onMailChange = viewModel::onMailChange,
        onPasswordChange = viewModel::onPasswordChange,
        onSignUp = viewModel::signUp,
        onUIEventHandled = viewModel::onUIEventHandled,
        onNavigateToLogin = onNavigateToLogin,
    )
}

fun NavController.navigateToSignUp() {
    this.navigate(signUpRoute) {
        popUpTo("main_graph") {
            this.inclusive = false
        }
    }
}