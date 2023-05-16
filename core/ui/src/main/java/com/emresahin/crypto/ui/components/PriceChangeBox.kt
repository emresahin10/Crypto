package com.emresahin.crypto.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun PriceChangeBox(
    modifier: Modifier = Modifier,
    text: String? = null,
) {
    Box(
        modifier = modifier
            .background(
                color = if (text
                        .toString()
                        .contains("-")
                ) Color.Red else Color.Green,
                shape = RoundedCornerShape(16.dp),
            )
            .padding(4.dp)
    ) {
        Text(text = "% ${text.toString().take(6)}", color = Color.White)
    }
}

@Preview(showBackground = true)
@Composable
private fun PriceChangeBoxNegativePreview() {
    PriceChangeBox(
        modifier = Modifier,
        text = "-0.2502"
    )
}

@Preview(showBackground = true)
@Composable
private fun PriceChangeBoxPositivePreview() {
    PriceChangeBox(
        modifier = Modifier,
        text = "2.1356"
    )
}