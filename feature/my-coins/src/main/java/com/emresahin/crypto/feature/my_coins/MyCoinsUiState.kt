package com.emresahin.crypto.feature.my_coins

import com.emresahin.crypto.model.Coin

data class MyCoinsUiState(
    val events: List<MyCoinsUIEvent> = emptyList(),
    val coins: List<Coin> = emptyList(),
)
