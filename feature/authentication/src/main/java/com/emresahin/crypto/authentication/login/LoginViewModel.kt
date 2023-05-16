package com.emresahin.crypto.authentication.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.emresahin.crypto.data.authentication.AuthenticationRepository
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
class LoginViewModel @Inject constructor(
    private val authenticationRepository: AuthenticationRepository,
) : ViewModel() {

    private val mViewState = MutableStateFlow(LoginUiState())
    val viewState: StateFlow<LoginUiState> = mViewState.asStateFlow()

    private fun emitNewEvent(event: LoginUIEvent) {
        mViewState.update { state -> state.copy(events = state.events + event) }
    }

    fun onUIEventHandled(event: UIEvent) {
        mViewState.update { state -> state.copy(events = state.events.filter { it.id != event.id }) }
    }

    fun login(email: String, password: String) = viewModelScope.launch {
        authenticationRepository.login(email, password).onSuccess {
            emitNewEvent(LoginUIEvent.NavigateToMarkets)
        }
    }


    fun onMailChange(mail: String) = mViewState.update { it.copy(mail = mail) }

    fun onPasswordChange(password: String) = mViewState.update { it.copy(password = password) }


}