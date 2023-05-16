package com.emresahin.crypto.network.source.coin_detail

import com.emresahin.crypto.Result
import com.emresahin.crypto.mapData
import com.emresahin.crypto.model.Coin
import com.emresahin.crypto.network.CryptoApiCall
import com.emresahin.crypto.network.api.CryptoApi
import com.emresahin.crypto.network.model.NetworkCoin
import com.emresahin.crypto.network.model.asExternal
import it.czerwinski.android.hilt.annotations.Bound
import javax.inject.Inject

@Bound
class CoinDetailNetworkDataSourceImpl @Inject constructor(
    private val cryptoApi: CryptoApi,
    private val cryptoApiCall: CryptoApiCall,
) : CoinDetailNetworkDataSource {

    override suspend fun getCoinDetail(vsCurrency: String, coinId: String): Result<List<Coin>> {
        return cryptoApiCall { cryptoApi.getCoinDetail(vsCurrency, coinId) }
            .mapData { it?.map(NetworkCoin::asExternal)!! }
    }
}