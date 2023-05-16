package com.emresahin.crypto.data.my_coins

import com.emresahin.crypto.Result
import com.emresahin.crypto.model.Coin
import com.emresahin.crypto.network.source.my_coins.MyCoinsNetworkDataSource
import it.czerwinski.android.hilt.annotations.Bound
import javax.inject.Inject

@Bound
class MyCoinsRepositoryImpl @Inject constructor(
    private val myCoinsNetworkDataSource: MyCoinsNetworkDataSource,
) : MyCoinsRepository {
    override suspend fun addCoinToFireStore(coin: Coin): Result<Boolean> {
        return myCoinsNetworkDataSource.addCoinToFireStore(coin)
    }

    override suspend fun getCoinFromFireStore(): Result<List<Coin>> {
        return myCoinsNetworkDataSource.getCoinFromFireStore()
    }
}