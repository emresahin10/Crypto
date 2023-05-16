package com.emresahin.crypto.app

import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.emresahin.crypto.authentication.login.loginRoute
import com.emresahin.crypto.authentication.signup.signUpRoute
import com.emresahin.crypto.components.CryptoBottomBar
import com.emresahin.crypto.navigation.CryptoHost

@Composable
fun rememberCryptoAppState(
    navController: NavHostController = rememberNavController(),
): CryptoAppState {
    return remember(navController) {
        CryptoAppState(navController)
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun CryptoApp(
    appState: CryptoAppState = rememberCryptoAppState(),
) {
    Scaffold(
        modifier = Modifier,
        bottomBar = {
            when (appState.currentDestination?.route) {
                signUpRoute, loginRoute -> {}
                else -> {
                    CryptoBottomBar(
                        destinations = appState.topLevelDestinations,
                        onNavigateToDestination = appState::navigateToMainDestination,
                        currentDestination = appState.currentDestination,
                    )
                }
            }
        }
    ) { innerPaddings ->
        CryptoHost(
            modifier = Modifier
                .consumeWindowInsets(innerPaddings)
                .padding(innerPaddings)
                .imePadding(),
            navController = appState.navController,
            onBackClick = appState::onBackClick
        )
    }
}