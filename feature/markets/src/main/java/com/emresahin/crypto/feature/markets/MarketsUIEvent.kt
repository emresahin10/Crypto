package com.emresahin.crypto.feature.markets

import com.emresahin.crypto.ui.model.UIEvent

sealed class MarketsUIEvent : UIEvent() {
    object NavigateToCoinDetail : MarketsUIEvent()
}
