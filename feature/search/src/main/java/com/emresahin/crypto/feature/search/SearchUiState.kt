package com.emresahin.crypto.feature.search

import com.emresahin.crypto.model.Coin

data class SearchUiState(
    val coins: List<Coin> = emptyList(),
    val query: String? = null,
    val events: List<SearchUIEvent> = emptyList(),
) {
    val vsCurrency: String
        get() = "usd"

    val appBarTitle: String
        get() = "SEARCH"
}