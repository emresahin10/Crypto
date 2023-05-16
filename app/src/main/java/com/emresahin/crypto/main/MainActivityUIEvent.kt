package com.emresahin.crypto.main

import com.emresahin.crypto.ui.model.UIEvent


sealed class MainActivityUIEvent : UIEvent() {
    data class Main(val routeDecider: String?) : MainActivityUIEvent()
}
