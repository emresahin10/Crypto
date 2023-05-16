package com.emresahin.crypto.navigation

import androidx.navigation.NavOptions

object CryptoNavOptions {
    val popUpToRootThenNavigate: NavOptions
        get() = NavOptions.Builder()
            .setPopUpTo(
                route = rootGraphRoute,
                inclusive = false,
                saveState = false,
            ).build()
}