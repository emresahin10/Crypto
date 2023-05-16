package com.emresahin.crypto.data.authentication

import com.emresahin.crypto.Result

interface AuthenticationRepository {
    suspend fun signUp(email: String, password: String): Result<Boolean>
    suspend fun login(email: String, password: String): Result<Boolean>
}