package com.emresahin.crypto.data.search

import com.emresahin.crypto.Result
import com.emresahin.crypto.model.Coin

interface SearchRepository {
    suspend fun getSearchResult(query: String): Result<List<Coin>>
}