package com.emresahin.crypto.components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.ListItemDefaults.contentColor
import androidx.compose.material3.NavigationBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CryptoNavigationBar(
    modifier: Modifier = Modifier,
    containerColor: Color,
    content: @Composable RowScope.() -> Unit,
) {
    NavigationBar(
        modifier = modifier,
        containerColor = containerColor,
        contentColor = contentColor,
        tonalElevation = 8.dp,
        content = content,
    )
}