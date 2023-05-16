package com.emresahin.crypto.feature.search

import com.emresahin.crypto.ui.model.UIEvent

sealed class SearchUIEvent : UIEvent() {
    data class NavigateToCoinDetail(val vsCurrency: String,val coinId: String) : SearchUIEvent()
}
