package com.emresahin.crypto.feature.search.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SearchTextField(
    modifier: Modifier,
    searchText: TextFieldValue,
    isClearTextIconVisible: Boolean = searchText.text.isNotEmpty(),
    doOnTextChange: (TextFieldValue) -> Unit,
    onClearTextIconClick: (() -> Unit),
    onImeActionSearch: () -> Unit,
) {
    var onSearchFocused by remember { mutableStateOf(false) }
    val focusManager = LocalFocusManager.current

    Row(
        modifier = modifier
            .height(40.dp)
            .border(
                width = 1.dp,
                shape = RoundedCornerShape(8.dp),
                color = MaterialTheme.colorScheme.secondary
            )
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.primary, RoundedCornerShape(8.dp)),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Filled.AccountBox,
            contentDescription = null,
            modifier = Modifier
                .padding(vertical = 10.dp)
                .padding(start = 14.dp)
                .size(20.dp),
            )
        BasicTextField(
            modifier = Modifier
                .padding(start = 8.dp, end = 16.dp)
                .fillMaxWidth()
                .weight(1f)
                .onFocusChanged {
                    onSearchFocused = it.hasFocus
                },
            value = searchText,
            textStyle = TextStyle(fontSize = 14.sp),
            onValueChange = doOnTextChange,
            singleLine = true,
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
            keyboardActions = KeyboardActions {
                focusManager.clearFocus()
                onImeActionSearch()
            },
            maxLines = 1,
            cursorBrush = SolidColor(value = MaterialTheme.colorScheme.onSurface)
        )

        if (isClearTextIconVisible) {
            IconButton(
                onClick = {
                    onClearTextIconClick()
                }
            ) {
                Icon(
                    imageVector = Icons.Rounded.Search,
                    contentDescription = null,
                    modifier = Modifier.padding(4.dp),
                )
            }
        }
    }
}