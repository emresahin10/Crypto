package com.emresahin.crypto.authentication.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.rounded.Face
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.emresahin.crypto.ui.model.CryptoAppBar
import com.emresahin.crypto.ui.model.UIEvent

@Composable
fun LoginScreen(
    state: LoginUiState,
    onLogin: (mail: String, password: String) -> Unit,
    onMailChange: (mail: String) -> Unit,
    onPasswordChange: (password: String) -> Unit,
    onUIEventHandled: (UIEvent) -> Unit,
    onNavigateToMarkets: () -> Unit,
) {
    var passwordVisible by rememberSaveable { mutableStateOf(false) }

    LaunchedEffect(state.events) {
        val event = state.events.firstOrNull() ?: return@LaunchedEffect
        when (event) {
            is LoginUIEvent.NavigateToMarkets -> {
                onNavigateToMarkets()
                onUIEventHandled(event)
            }
        }
    }

    Column(modifier = Modifier.fillMaxSize()) {
        CryptoAppBar(title = state.appBarTitle)
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            value = state.mail.orEmpty(),
            onValueChange = onMailChange,
            label = { Text(text = state.mailPlaceholder) }
        )
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            value = state.password.orEmpty(),
            onValueChange = onPasswordChange,
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            label = { Text(text = state.passwordPlaceholder) },
            trailingIcon = {
                val image = if (passwordVisible) Icons.Rounded.Face else Icons.Outlined.Info // Add proper icons
                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    Icon(imageVector = image, null)
                }
            }
        )
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(32.dp),
            onClick = { onLogin(state.mail.orEmpty(), state.password.orEmpty()) },
        ) {
            Text(text = state.loginText)
        }
    }

}