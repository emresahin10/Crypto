package com.emresahin.crypto.authentication.login

data class LoginUiState(
    val events: List<LoginUIEvent> = emptyList(),
    val mail: String? = null,
    val password: String? = null,
){
    val appBarTitle: String
        get() = "LOGIN"

    val mailPlaceholder: String
        get() = "Mail"

    val passwordPlaceholder: String
        get() = "Password"

    val loginText: String
        get() = "LOGIN"
}
