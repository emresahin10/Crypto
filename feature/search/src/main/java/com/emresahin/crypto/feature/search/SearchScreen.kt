package com.emresahin.crypto.feature.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.emresahin.crypto.feature.search.component.SearchItem
import com.emresahin.crypto.ui.extensions.noRippleClickable
import com.emresahin.crypto.ui.model.CryptoAppBar
import com.emresahin.crypto.ui.model.UIEvent

@Composable
internal fun SearchScreen(
    state: SearchUiState,
    fetchSearchResults: () -> Unit,
    clearText: () -> Unit,
    onQueryChange: (query: String) -> Unit,
    onNavigateToCoinDetail: (vsCurrency: String, coinId: String) -> Unit,
    onUIEventHandled: (UIEvent) -> Unit,
) {
    val focusManager = LocalFocusManager.current

    LaunchedEffect(state.events) {
        val event = state.events.firstOrNull() ?: return@LaunchedEffect
        when (event) {
            is SearchUIEvent.NavigateToCoinDetail -> {
                //onNavigateToCoinDetail(event.vsCurrency, event.coinId)
                onUIEventHandled(event)
            }
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.primary)
    ) {
        CryptoAppBar(title = state.appBarTitle)
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 8.dp, top = 24.dp, bottom = 16.dp, start = 8.dp),
            value = state.query.orEmpty(),
            onValueChange = onQueryChange,
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
            keyboardActions = KeyboardActions(
                onSearch = {
                    fetchSearchResults()
                    focusManager.clearFocus()
                }
            ),
            singleLine = true,
            maxLines = 1,
            leadingIcon = {
                Icon(
                    modifier = Modifier.noRippleClickable {
                        fetchSearchResults()
                        focusManager.clearFocus()
                    },
                    imageVector = Icons.Default.Search,
                    contentDescription = null,
                )
            },
            trailingIcon = {
                IconButton(onClick = clearText) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = "Cancel",
                    )
                }
            },
            textStyle = TextStyle(color = MaterialTheme.colorScheme.onSurface),
            shape = MaterialTheme.shapes.large,
        )

        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(8.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            items(state.coins) { coin ->
                SearchItem(
                    id = coin.id,
                    name = coin.name,
                    symbol = coin.symbol,
                    image = coin.large,
                    onClick = { onNavigateToCoinDetail(state.vsCurrency, coin.id) }
                )
            }
        }
    }

}
