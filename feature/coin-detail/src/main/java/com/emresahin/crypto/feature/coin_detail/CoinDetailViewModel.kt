package com.emresahin.crypto.feature.coin_detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.emresahin.crypto.data.coin_detail.CoinDetailRepository
import com.emresahin.crypto.data.my_coins.MyCoinsRepository
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
class CoinDetailViewModel @Inject constructor(
    private val coinDetailRepository: CoinDetailRepository,
    private val myCoinsRepository: MyCoinsRepository,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val vsCurrency: String = CoinDetailArgs(savedStateHandle).vsCurrency
    private val coinId: String = CoinDetailArgs(savedStateHandle).coinId

    private val mViewState = MutableStateFlow(CoinDetailUiState())
    val viewState: StateFlow<CoinDetailUiState> = mViewState.asStateFlow()

    private fun emitNewEvent(event: CoinDetailUIEvent) {
        mViewState.update { state -> state.copy(events = state.events + event) }
    }

    fun onUIEventHandled(event: UIEvent) {
        mViewState.update { state -> state.copy(events = state.events.filter { it.id != event.id }) }
    }

    init {
        fetchCoinDetail()
    }


    private fun fetchCoinDetail() = viewModelScope.launch {
        coinDetailRepository.getCoinDetail(vsCurrency = vsCurrency, coinId = coinId)
            .onSuccess { coins ->
                mViewState.update { it.copy(coins = coins) }
            }
    }

    fun onSaveToMyCoins() = viewModelScope.launch {
        val coin = mViewState.value.coins?.get(0)!!
        myCoinsRepository.addCoinToFireStore(coin).onSuccess {
            emitNewEvent(CoinDetailUIEvent.Event)
        }
    }
}