package com.emresahin.crypto.network.source.search

import com.emresahin.crypto.Result
import com.emresahin.crypto.model.Coin

interface SearchNetworkDataSource {
    suspend fun getSearchResult(query: String): Result<List<Coin>>
}