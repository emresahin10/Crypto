package com.emresahin.crypto.feature.my_coins

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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
class MyCoinsViewModel @Inject constructor(
    private val myCoinsRepository: MyCoinsRepository,
) : ViewModel() {

    private val mViewState = MutableStateFlow(MyCoinsUiState())
    val viewState: StateFlow<MyCoinsUiState> = mViewState.asStateFlow()

    init {
        fetchMyCoins()
    }

    private fun emitNewEvent(event: MyCoinsUIEvent) {
        mViewState.update { state -> state.copy(events = state.events + event) }
    }

    fun onUIEventHandled(event: UIEvent) {
        mViewState.update { state -> state.copy(events = state.events.filter { it.id != event.id }) }
    }

    private fun fetchMyCoins() = viewModelScope.launch {
        myCoinsRepository.getCoinFromFireStore().onSuccess { coins ->
            mViewState.update { it.copy(coins = coins) }
        }
    }
}