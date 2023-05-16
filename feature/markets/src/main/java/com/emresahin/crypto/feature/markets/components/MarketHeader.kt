package com.emresahin.crypto.feature.markets.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MarketHeader(
    modifier: Modifier = Modifier,
    name: String? = null,
    price: String? = null,
    priceChange24h: String? = null,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(color = MaterialTheme.colorScheme.primary)
            .padding(horizontal = 20.dp, vertical = 12.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Spacer(modifier = Modifier.padding(horizontal = 24.dp))
        Text(
            text = name.orEmpty(),
            color = Color.Yellow,
            fontSize = 14.sp,
        )
        Text(
            text = price.orEmpty(),
            color = Color.Yellow,
            fontSize = 14.sp,
        )
        Text(
            text = priceChange24h.orEmpty(),
            color = Color.Yellow,
            fontSize = 14.sp,
        )
    }
}