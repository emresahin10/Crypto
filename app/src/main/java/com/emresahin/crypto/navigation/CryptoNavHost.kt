package com.emresahin.crypto.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.emresahin.crypto.authentication.login.loginScreen
import com.emresahin.crypto.authentication.login.navigateToLogin
import com.emresahin.crypto.authentication.signup.signUpRoute
import com.emresahin.crypto.authentication.signup.signUpScreen
import com.emresahin.crypto.feature.coin_detail.coinDetailScreen
import com.emresahin.crypto.feature.coin_detail.navigateToCoinDetail
import com.emresahin.crypto.feature.markets.marketsScreen
import com.emresahin.crypto.feature.markets.navigateToMarkets
import com.emresahin.crypto.feature.my_coins.myCoinsScreen
import com.emresahin.crypto.feature.search.searchScreen

const val rootGraphRoute = "root"

@Composable
fun CryptoHost(
    navController: NavHostController,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
    startDestination: String = signUpRoute,
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier,
        route = rootGraphRoute
    ) {
        /*authenticationGraph(
            onNavigateToLogin = navController::navigateToLogin,
            nestedGraph = {
                loginScreen(
                    onNavigateToMarkets = {
                        navController.navigateToMarkets(
                            options = CryptoNavOptions.popUpToRootThenNavigate
                        )
                    }
                )
            }
        )*/
        signUpScreen(onNavigateToLogin = navController::navigateToLogin)
        loginScreen(
            onNavigateToMarkets = {
                navController.navigateToMarkets(
                    options = CryptoNavOptions.popUpToRootThenNavigate
                )
            }
        )
        marketsScreen(onNavigateToCoinDetail = navController::navigateToCoinDetail)
        searchScreen(onNavigateToCoinDetail = navController::navigateToCoinDetail)
        coinDetailScreen(onNavigateBack = onBackClick)
        myCoinsScreen()
    }
}