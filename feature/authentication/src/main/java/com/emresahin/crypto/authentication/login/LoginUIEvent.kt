package com.emresahin.crypto.authentication.login

import com.emresahin.crypto.ui.model.UIEvent

sealed class LoginUIEvent : UIEvent(){
    object NavigateToMarkets : LoginUIEvent()
}
