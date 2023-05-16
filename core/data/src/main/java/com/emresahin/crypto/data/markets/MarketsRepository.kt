package com.emresahin.crypto.data.markets

import com.emresahin.crypto.Result
import com.emresahin.crypto.model.Coin

interface MarketsRepository {
    suspend fun getMarkets(vsCurrency: String): Result<List<Coin>>
}