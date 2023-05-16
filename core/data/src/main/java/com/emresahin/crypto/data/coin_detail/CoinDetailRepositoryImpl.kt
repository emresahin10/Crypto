package com.emresahin.crypto.data.coin_detail

import com.emresahin.crypto.Result
import com.emresahin.crypto.model.Coin
import com.emresahin.crypto.network.source.coin_detail.CoinDetailNetworkDataSource
import it.czerwinski.android.hilt.annotations.Bound
import javax.inject.Inject

@Bound
class CoinDetailRepositoryImpl @Inject constructor(
    private val coinDetailNetworkDataSource: CoinDetailNetworkDataSource,
) : CoinDetailRepository {

    override suspend fun getCoinDetail(vsCurrency: String, coinId: String): Result<List<Coin>> {
        return coinDetailNetworkDataSource.getCoinDetail(vsCurrency, coinId)
    }
}