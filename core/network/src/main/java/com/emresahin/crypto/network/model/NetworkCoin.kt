package com.emresahin.crypto.network.model

import com.emresahin.crypto.common.extension.orZero
import com.emresahin.crypto.model.Coin
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NetworkCoin(
    val id: String,
    val symbol: String? = null,
    val name: String? = null,
    val image: String? = null,
    @SerialName("current_price")
    val currentPrice: Double? = null,
    @SerialName("high_24h")
    val high24H: Double? = null,
    @SerialName("low_24h")
    val low24H: Double? = null,
    @SerialName("price_change_24h")
    val priceChange24h: Double? = null,
    @SerialName("price_change_percentage_24h")
    val priceChangePercentage24h: Double? = null,
    val thumb: String? = null,
    val large: String? = null,
)

fun NetworkCoin.asExternal(): Coin = Coin(
    id = id,
    symbol = symbol.orEmpty(),
    name = name.orEmpty(),
    image = image.orEmpty(),
    currentPrice = currentPrice.orZero(),
    high24H = high24H.orZero(),
    low24H = low24H.orZero(),
    priceChange24h = priceChange24h.orZero(),
    priceChangePercentage24h = priceChangePercentage24h.orZero(),
    thumb = thumb.orEmpty(),
    large = large.orEmpty(),
)
