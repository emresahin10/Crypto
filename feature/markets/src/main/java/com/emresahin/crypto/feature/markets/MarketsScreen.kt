package com.emresahin.crypto.feature.markets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.emresahin.crypto.feature.markets.components.MarketHeader
import com.emresahin.crypto.feature.markets.components.MarketItem
import com.emresahin.crypto.ui.model.CryptoAppBar
import com.emresahin.crypto.ui.model.UIEvent

@Composable
internal fun MarketsScreen(
    state: MarketsUiState,
    onNavigateToCoinDetail: (vsCurrency: String, coinId: String) -> Unit,
    onUIEventHandled: (UIEvent) -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.primary)
    ) {
        CryptoAppBar(title = state.appBarTitle)
        MarketHeader(
            modifier = Modifier.fillMaxWidth(),
            name = state.headerTitle,
            price = state.priceTitle,
            priceChange24h = state.priceDifTitle
        )
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(8.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(state.coins) { coin ->
                MarketItem(
                    id = coin.id,
                    name = coin.name,
                    symbol = coin.symbol,
                    currentPrice = coin.currentPrice,
                    priceChangePercentage24h = coin.priceChangePercentage24h,
                    image = coin.image,
                    onClick = { onNavigateToCoinDetail("usd", coin.id) }
                )
            }
        }
    }

}