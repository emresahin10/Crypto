package com.emresahin.crypto.data.authentication

import com.emresahin.crypto.Result
import com.emresahin.crypto.network.source.authentication.AuthenticationNetworkDataSource
import it.czerwinski.android.hilt.annotations.Bound
import javax.inject.Inject

@Bound
class AuthenticationRepositoryImpl @Inject constructor(
    private val authenticationNetworkDataSource: AuthenticationNetworkDataSource,
) : AuthenticationRepository {

    override suspend fun signUp(email: String, password: String): Result<Boolean> {
        return authenticationNetworkDataSource.signUp(email, password)
    }

    override suspend fun login(email: String, password: String): Result<Boolean> {
        return authenticationNetworkDataSource.login(email, password)
    }
}