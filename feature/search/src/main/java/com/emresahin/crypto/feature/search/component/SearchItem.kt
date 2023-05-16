package com.emresahin.crypto.feature.search.component

import androidx.compose.foundation.background
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
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.emresahin.crypto.ui.extensions.noRippleClickable

@Composable
fun SearchItem(
    modifier: Modifier = Modifier,
    id: String,
    name: String,
    symbol: String,
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
    ) {
        AsyncImage(
            modifier = Modifier
                .size(36.dp)
                .clip(CircleShape)
                .padding(4.dp),
            model = image,
            contentDescription = name
        )
        Column(horizontalAlignment = Alignment.Start) {
            Text(text = name, color = Color.White)
            Text(text = symbol.uppercase(), color = Color.LightGray)
        }
    }
}