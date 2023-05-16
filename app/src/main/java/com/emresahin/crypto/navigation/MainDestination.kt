package com.emresahin.crypto.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.Star
import androidx.compose.ui.graphics.vector.ImageVector

enum class MainDestination(
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
) {
    MARKETS(
        selectedIcon = Icons.Filled.Home,
        unselectedIcon = Icons.Outlined.Home,
    ),
    SEARCH(
        selectedIcon = Icons.Filled.Search,
        unselectedIcon = Icons.Outlined.Search,
    ),
    MY_COINS(
        selectedIcon = Icons.Filled.Star,
        unselectedIcon = Icons.Outlined.Star,
    ),
}