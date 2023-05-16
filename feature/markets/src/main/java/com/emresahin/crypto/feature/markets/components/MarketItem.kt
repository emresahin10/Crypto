package com.emresahin.crypto.feature.markets.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.emresahin.crypto.ui.extensions.noRippleClickable

@Composable
fun MarketItem(
    modifier: Modifier = Modifier,
    id: String,
    name: String,
    symbol: String,
    currentPrice: Double,
    priceChangePercentage24h: Double,
    image: String,
    onClick: (coinId: String) -> Unit,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.DarkGray, shape = RoundedCornerShape(16.dp))
            .noRippleClickable { onClick(id) }
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        AsyncImage(
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape)
                .padding(4.dp),
            model = image,
            contentDescription = name
        )
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = name, color = Color.White)
            Text(text = symbol.uppercase(), color = Color.White)
        }
        Text(text = "$${currentPrice.toString().take(7)}", color = Color.White)
        PriceChangeBox(text = priceChangePercentage24h.toString())
    }
}

@Preview(showBackground = true)
@Composable
private fun CryptoMarketItemPreview() {
    MarketItem(
        modifier = Modifier,
        id = "id",
        name = "Bitcoin",
        symbol = "BTC",
        currentPrice = 2700.10,
        priceChangePercentage24h = 0.1235,
        image = "image",
        onClick = {}
    )
}
