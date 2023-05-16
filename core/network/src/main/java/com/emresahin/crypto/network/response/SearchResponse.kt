package com.emresahin.crypto.network.response

import com.emresahin.crypto.network.model.NetworkCoin
import kotlinx.serialization.Serializable

@Serializable
data class SearchResponse(
    val coins: List<NetworkCoin>
)