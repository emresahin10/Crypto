package com.emresahin.crypto.data.coin_detail

import com.emresahin.crypto.Result
import com.emresahin.crypto.model.Coin

interface CoinDetailRepository {
    suspend fun getCoinDetail(vsCurrency: String, coinId: String): Result<List<Coin>>

}