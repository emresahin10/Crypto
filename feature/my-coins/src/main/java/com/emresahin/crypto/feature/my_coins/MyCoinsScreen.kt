package com.emresahin.crypto.feature.my_coins

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import coil.compose.AsyncImage
import com.emresahin.crypto.ui.model.UIEvent

@Composable
internal fun MyCoinsScreen(
    state: MyCoinsUiState,
    onUIEventHandled: (UIEvent) -> Unit,
) {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "MY COINS")
        LazyColumn {
            items(state.coins) { coin ->
                Text(text = coin.name)
                AsyncImage(model = coin.image, contentDescription = null)
            }
        }
    }
}