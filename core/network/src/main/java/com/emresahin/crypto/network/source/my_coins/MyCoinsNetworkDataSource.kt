package com.emresahin.crypto.network.source.my_coins

import com.emresahin.crypto.Result
import com.emresahin.crypto.model.Coin

interface MyCoinsNetworkDataSource {
    suspend fun addCoinToFireStore(coin: Coin): Result<Boolean>
    suspend fun getCoinFromFireStore(): Result<List<Coin>>
}