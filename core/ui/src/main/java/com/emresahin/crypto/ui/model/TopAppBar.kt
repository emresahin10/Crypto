package com.emresahin.crypto.ui.model

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CryptoAppBar(
    modifier: Modifier = Modifier,
    title: String,
    color: Color = Color.DarkGray,
    shadowElevation: Dp = 2.dp,
    navigationIcon: ImageVector? = null,
    menuIcon: ImageVector? = null,
    tintColor: Color = Color.White,
    onNavigationIconClick: (() -> Unit)? = null,
    onMenuIconClick: (() -> Unit)? = null,
) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp),
        color = color,
        shadowElevation = shadowElevation,
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            if (navigationIcon != null) {
                IconButton(
                    modifier = Modifier
                        .padding(start = 16.dp)
                        .size(24.dp),
                    onClick = { onNavigationIconClick?.invoke() }
                ) {
                    Image(
                        imageVector = navigationIcon,
                        contentDescription = null,
                        colorFilter = ColorFilter.tint(color = tintColor)
                    )
                }
            } else {
                Spacer(modifier = Modifier.size(24.dp))
            }
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                color = Color.White,
                text = title,
                textAlign = TextAlign.Center,
                fontSize = 16.sp,
            )
            if (menuIcon != null) {
                IconButton(
                    modifier = Modifier
                        .padding(end = 16.dp)
                        .size(24.dp),
                    onClick = { onMenuIconClick?.invoke() }
                ) {
                    Image(
                        imageVector = menuIcon,
                        contentDescription = null,
                        colorFilter = ColorFilter.tint(color = tintColor)
                    )
                }
            } else {
                Spacer(modifier = Modifier.size(24.dp))
            }
        }
    }
}

@Preview
@Composable
private fun CryptoAppBarPreview() {

    CryptoAppBar(
        title = "GİRİŞ YAP",
        navigationIcon = Icons.Default.ArrowBack,
    )
}