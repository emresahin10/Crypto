package com.emresahin.crypto.app

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.navOptions
import androidx.tracing.trace
import com.emresahin.crypto.feature.markets.navigateToMarkets
import com.emresahin.crypto.feature.my_coins.navigateToMyCoins
import com.emresahin.crypto.feature.search.navigateToSearch
import com.emresahin.crypto.navigation.MainDestination

@Stable
data class CryptoAppState(val navController: NavHostController) {

    val currentDestination: NavDestination?
        @Composable get() = navController
            .currentBackStackEntryAsState().value?.destination

    val topLevelDestinations: List<MainDestination> = MainDestination.values().asList()

    fun onBackClick() {
        navController.popBackStack()
    }

    fun navigateToMainDestination(mainDestination: MainDestination) {
        trace("Navigation: ${mainDestination.name}") {
            val mainLevelNavOptions = navOptions {
                popUpTo(navController.graph.findStartDestination().id) {
                    saveState = true
                }
                launchSingleTop = true
                restoreState = true
            }

            when (mainDestination) {
                MainDestination.MARKETS -> navController.navigateToMarkets(mainLevelNavOptions)
                MainDestination.SEARCH -> navController.navigateToSearch(mainLevelNavOptions)
                MainDestination.MY_COINS -> navController.navigateToMyCoins(mainLevelNavOptions)
            }
        }
    }
}