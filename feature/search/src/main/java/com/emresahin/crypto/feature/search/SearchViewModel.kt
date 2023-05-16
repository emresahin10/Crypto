package com.emresahin.crypto.feature.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.emresahin.crypto.data.search.SearchRepository
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
class SearchViewModel @Inject constructor(
    private val searchRepository: SearchRepository,
) : ViewModel() {

    private val mViewState = MutableStateFlow(SearchUiState())
    val viewState: StateFlow<SearchUiState> = mViewState.asStateFlow()

    private fun emitNewEvent(event: SearchUIEvent) {
        mViewState.update { state -> state.copy(events = state.events + event) }
    }

    fun onUIEventHandled(event: UIEvent) {
        mViewState.update { state -> state.copy(events = state.events.filter { it.id != event.id }) }
    }

    fun fetchSearchResults() = viewModelScope.launch {
        val query = mViewState.value.query ?: ""
        searchRepository.getSearchResult(query).onSuccess { coins ->
            mViewState.update { it.copy(coins = coins) }
        }
    }


    fun onQueryChange(query: String) = mViewState.update { it.copy(query = query) }

    fun clearText() = mViewState.update { it.copy(query = "", coins = emptyList()) }

}