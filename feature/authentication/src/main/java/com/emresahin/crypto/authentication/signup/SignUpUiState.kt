package com.emresahin.crypto.authentication.signup

data class SignUpUiState(
    val events: List<SignUpUIEvent> = emptyList(),
    val mail: String? = null,
    val password: String? = null,
) {
    val isSignUpEnabled: Boolean
        get() = mail?.length != null && password?.length != null

    val appBarTitle: String
        get() = "SIGN UP"

    val mailPlaceholder: String
        get() = "Mail"

    val passwordPlaceholder: String
        get() = "Password"

    val signUpText: String
        get() = "SIGN UP"
}
