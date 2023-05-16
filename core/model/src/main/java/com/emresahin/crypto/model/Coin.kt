package com.emresahin.crypto.model

data class Coin(
    val id: String,
    val symbol: String,
    val name: String,
    val image: String,
    val currentPrice: Double,
    val high24H: Double,
    val low24H: Double,
    val priceChange24h: Double,
    val priceChangePercentage24h: Double,
    val thumb: String,
    val large: String,
)
