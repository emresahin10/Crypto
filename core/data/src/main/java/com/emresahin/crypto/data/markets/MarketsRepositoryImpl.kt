package com.emresahin.crypto.data.markets

import com.emresahin.crypto.Result
import com.emresahin.crypto.model.Coin
import com.emresahin.crypto.network.source.markets.MarketsNetworkDataSource
import it.czerwinski.android.hilt.annotations.Bound
import javax.inject.Inject

@Bound
class MarketsRepositoryImpl @Inject constructor(
    private val marketsNetworkDataSource: MarketsNetworkDataSource,
) : MarketsRepository {

    override suspend fun getMarkets(vsCurrency: String): Result<List<Coin>> {
        return marketsNetworkDataSource.getMarkets(vsCurrency)
    }
}