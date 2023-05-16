package com.emresahin.crypto.authentication.signup

import com.emresahin.crypto.ui.model.UIEvent

sealed class SignUpUIEvent : UIEvent(){
    object NavigateToLogin : SignUpUIEvent()
}
