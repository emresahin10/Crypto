package com.emresahin.crypto.feature.markets

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.emresahin.crypto.data.markets.MarketsRepository
import com.emresahin.crypto.onSuccess
import com.emresahin.crypto.ui.model.UIEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MarketsViewModel @Inject constructor(
    private val marketsRepository: MarketsRepository,
) : ViewModel() {

    private val mViewState = MutableStateFlow(MarketsUiState())
    val viewState: StateFlow<MarketsUiState> = mViewState.asStateFlow()

    private fun emitNewEvent(event: MarketsUIEvent) {
        mViewState.update { state -> state.copy(events = state.events + event) }
    }

    fun onUIEventHandled(event: UIEvent) {
        mViewState.update { state -> state.copy(events = state.events.filter { it.id != event.id }) }
    }

    init {
        fetchMarkets()
    }

    private fun fetchMarkets() = viewModelScope.launch {
        marketsRepository.getMarkets(vsCurrency = "usd").onSuccess { coins ->
            mViewState.update { it.copy(coins = coins) }
        }
    }


}