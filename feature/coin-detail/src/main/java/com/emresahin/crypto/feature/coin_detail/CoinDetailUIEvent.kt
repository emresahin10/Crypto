package com.emresahin.crypto.feature.coin_detail

import com.emresahin.crypto.ui.model.UIEvent

sealed class CoinDetailUIEvent: UIEvent() {
    object Event : CoinDetailUIEvent()

}