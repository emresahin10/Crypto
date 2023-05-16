package com.emresahin.crypto.network.source.my_coins

import com.emresahin.crypto.Result
import com.emresahin.crypto.model.Coin
import com.google.firebase.firestore.FirebaseFirestore
import it.czerwinski.android.hilt.annotations.Bound
import javax.inject.Inject

@Bound
class MyCoinsNetworkDataSourceImpl @Inject constructor(
    private val firebaseFirestore: FirebaseFirestore,
) : MyCoinsNetworkDataSource {

    override suspend fun addCoinToFireStore(coin: Coin): Result<Boolean> {
        return try {
            firebaseFirestore.collection("coins").add(coin)
            Result.Success(true)
        } catch (e: Exception) {
            Result.error(e.message.toString())
        }
    }

    override suspend fun getCoinFromFireStore(): Result<List<Coin>> {
        return try {
            /*firebaseFirestore.collection("coins").get().addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val result = task.result
                    result?.let {
                        Result.Success(it.documents.mapNotNull { documentSnapshot ->
                            documentSnapshot.toObject(Coin::class.java)
                        }
                        )
                    }
                }
            }*/
            /*val coins = firebaseFirestore
                .collection("coins")
                .document(firebaseAuth.currentUser?.uid.orEmpty())
                .get()
                .await().toObject(Coin::class.java)!!
            Result.Success(listOf(coins))*/

            //Fail
            Result.Success(emptyList())
        } catch (e: Exception) {
            Result.error(e.message.toString())
        }
    }
}
