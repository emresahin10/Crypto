package com.emresahin.crypto.network.source.search

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
class SearchNetworkDataSourceImpl @Inject constructor(
    private val cryptoApi: CryptoApi,
    private val cryptoApiCall: CryptoApiCall,
) : SearchNetworkDataSource {

    override suspend fun getSearchResult(query: String): Result<List<Coin>> {
        return cryptoApiCall { cryptoApi.getSearchResult(query) }
            .mapData { it?.coins?.map(NetworkCoin::asExternal).orEmpty() }
    }
}