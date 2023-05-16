package com.emresahin.crypto.network.source.authentication

import com.emresahin.crypto.Result

interface AuthenticationNetworkDataSource {
    suspend fun signUp(email: String, password: String): Result<Boolean>
    suspend fun login(email: String, password: String): Result<Boolean>
}