package com.emresahin.crypto.network.api

import com.emresahin.crypto.network.model.NetworkCoin
import com.emresahin.crypto.network.response.SearchResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface CryptoApi {

    @GET("coins/markets")
    suspend fun getMarkets(@Query("vs_currency") vsCurrency: String = "usd"): List<NetworkCoin>

    @GET("search")
    suspend fun getSearchResult(@Query("query") query: String): SearchResponse

    @GET("coins/markets")
    suspend fun getCoinDetail(
        @Query("vs_currency") vsCurrency: String = "usd",
        @Query("ids") coinId: String
    ): List<NetworkCoin>

}