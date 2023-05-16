package com.emresahin.crypto.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.emresahin.crypto.app.CryptoApp
import com.emresahin.crypto.app.rememberCryptoAppState
import com.emresahin.crypto.ui.theme.CryptoTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val appState = rememberCryptoAppState()
            CryptoTheme {
                CryptoApp(appState)
            }
        }
    }
}
