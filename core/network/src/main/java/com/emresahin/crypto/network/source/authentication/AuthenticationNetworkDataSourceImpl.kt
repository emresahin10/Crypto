package com.emresahin.crypto.network.source.authentication

import com.emresahin.crypto.Result
import com.google.firebase.auth.FirebaseAuth
import it.czerwinski.android.hilt.annotations.Bound
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

@Bound
class AuthenticationNetworkDataSourceImpl @Inject constructor(
    private val firebaseAuth: FirebaseAuth,
) : AuthenticationNetworkDataSource {

    override suspend fun signUp(email: String, password: String): Result<Boolean> {
        return try {
            firebaseAuth.createUserWithEmailAndPassword(email, password).await()
            Result.Success(true)
        } catch (e: Exception) {
            Result.error(e.message.toString())
        }
    }

    override suspend fun login(email: String, password: String): Result<Boolean> {
        return try {
            firebaseAuth.signInWithEmailAndPassword(email, password).await()
            Result.Success(true)
        } catch (e: Exception) {
            Result.error(e.message.toString())
        }
    }
}