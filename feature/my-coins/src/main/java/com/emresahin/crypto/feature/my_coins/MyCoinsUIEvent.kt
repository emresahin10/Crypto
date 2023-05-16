package com.emresahin.crypto.feature.my_coins

import com.emresahin.crypto.ui.model.UIEvent

sealed class MyCoinsUIEvent: UIEvent() {
    object Event : MyCoinsUIEvent()
}
