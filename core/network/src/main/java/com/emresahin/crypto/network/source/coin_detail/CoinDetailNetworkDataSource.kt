package com.emresahin.crypto.network.source.coin_detail

import com.emresahin.crypto.Result
import com.emresahin.crypto.model.Coin

interface CoinDetailNetworkDataSource {
    suspend fun getCoinDetail(vsCurrency: String, coinId: String): Result<List<Coin>>
}