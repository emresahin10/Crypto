package com.emresahin.crypto.feature.markets

import com.emresahin.crypto.model.Coin

data class MarketsUiState(
    val events: List<MarketsUIEvent> = emptyList(),
    val vsCurrency: String? = null,
    val coins: List<Coin> = emptyList()
){
    val appBarTitle: String = "MARKETS"
    val headerTitle: String = "Name"
    val priceTitle: String = "Price"
    val priceDifTitle: String = "24H % Dif"
}
