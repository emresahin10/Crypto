package com.emresahin.crypto.network.source.markets

import com.emresahin.crypto.Result
import com.emresahin.crypto.model.Coin

interface MarketsNetworkDataSource {
    suspend fun getMarkets(vsCurrency: String): Result<List<Coin>>
}