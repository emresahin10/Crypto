package com.emresahin.crypto.feature.coin_detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.emresahin.crypto.ui.components.PriceChangeBox
import com.emresahin.crypto.ui.model.CryptoAppBar
import com.emresahin.crypto.ui.model.UIEvent

@Composable
internal fun CoinDetailScreen(
    state: CoinDetailUiState,
    onSaveToMyCoins: () -> Unit,
    onNavigateBack: () -> Unit,
    onUIEventHandled: (UIEvent) -> Unit,
) {

    LaunchedEffect(state.events) {
        val event = state.events.firstOrNull() ?: return@LaunchedEffect
        when (event) {
            is CoinDetailUIEvent.Event -> {
                //Popupevent
                onUIEventHandled(event)
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.primary)
    ) {
        CryptoAppBar(
            title = state.appBarTitle,
            navigationIcon = Icons.Outlined.ArrowBack,
            menuIcon = Icons.Outlined.Star,
            onNavigationIconClick = onNavigateBack,
            onMenuIconClick = onSaveToMyCoins,
        )
        LazyColumn {
            items(state.coins.orEmpty()) { coin ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    AsyncImage(
                        modifier = Modifier
                            .size(70.dp)
                            .padding(16.dp),
                        model = coin.image,
                        contentDescription = null
                    )
                    Column(
                        modifier = Modifier.weight(1f),
                        horizontalAlignment = Alignment.Start
                    ) {
                        Text(
                            text = coin.name,
                            color = Color.White,
                            fontSize = 24.sp
                        )
                        Text(
                            text = coin.symbol.uppercase(),
                            color = Color.LightGray,
                            fontSize = 16.sp
                        )
                    }
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            modifier = Modifier.padding(end = 16.dp),
                            text = "$ ${coin.currentPrice}",
                            color = Color.LightGray,
                            fontSize = 20.sp
                        )
                        PriceChangeBox(text = coin.priceChangePercentage24h.toString())
                    }
                }

            }
        }
    }
}