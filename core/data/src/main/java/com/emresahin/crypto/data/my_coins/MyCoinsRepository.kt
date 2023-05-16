package com.emresahin.crypto.data.my_coins

import com.emresahin.crypto.Result
import com.emresahin.crypto.model.Coin

interface MyCoinsRepository {
    suspend fun addCoinToFireStore(coin: Coin): Result<Boolean>
    suspend fun getCoinFromFireStore(): Result<List<Coin>>
}