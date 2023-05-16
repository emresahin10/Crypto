package com.emresahin.crypto.data.search

import com.emresahin.crypto.Result
import com.emresahin.crypto.model.Coin
import com.emresahin.crypto.network.source.search.SearchNetworkDataSource
import it.czerwinski.android.hilt.annotations.Bound
import javax.inject.Inject

@Bound
class SearchRepositoryImpl @Inject constructor(
    private val searchNetworkDataSource: SearchNetworkDataSource
) : SearchRepository {

    override suspend fun getSearchResult(query: String): Result<List<Coin>> {
        return searchNetworkDataSource.getSearchResult(query)
    }
}