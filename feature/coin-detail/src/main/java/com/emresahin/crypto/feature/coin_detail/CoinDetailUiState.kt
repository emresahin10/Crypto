package com.emresahin.crypto.feature.coin_detail

import com.emresahin.crypto.model.Coin

data class CoinDetailUiState(
    val events: List<CoinDetailUIEvent> = emptyList(),
    val coins: List<Coin>? = emptyList(),
){
    val appBarTitle: String = "COIN DETAIL"
}
