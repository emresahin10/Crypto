package com.emresahin.crypto.authentication.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.navigation
import com.emresahin.crypto.authentication.signup.signUpRoute
import com.emresahin.crypto.authentication.signup.signUpScreen

const val authenticationGraphRoot = "authentication_graph"

fun NavGraphBuilder.authenticationGraph(
    onNavigateToLogin: () -> Unit,
    nestedGraph: NavGraphBuilder.() -> Unit,
) {
    navigation(
        route = authenticationGraphRoot,
        startDestination = signUpRoute
    ) {
        signUpScreen(onNavigateToLogin = onNavigateToLogin)
        nestedGraph()
    }
}

fun NavController.navigateToAuthenticationGraph(options: NavOptions? = null) {
    navigate(route = authenticationGraphRoot, navOptions = options)
}