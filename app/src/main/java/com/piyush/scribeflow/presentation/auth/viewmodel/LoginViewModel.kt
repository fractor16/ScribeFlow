package com.piyush.scribeflow.presentation.auth.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.piyush.scribeflow.domain.repository.AuthRepository
import com.piyush.scribeflow.presentation.auth.LoginUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val authRepository: AuthRepository
) : ViewModel() {

    private val _uiState =
        MutableStateFlow(LoginUiState())

    val uiState = _uiState.asStateFlow()

    fun onEmailChange(value: String) {

        _uiState.update {
            it.copy(
                email = value
            )
        }
    }

    fun onPasswordChange(value: String) {

        _uiState.update {
            it.copy(
                password = value
            )
        }
    }

    fun login() {

        viewModelScope.launch {

            _uiState.update {
                it.copy(
                    isLoading = true
                )
            }

            val success =
                authRepository.login(
                    _uiState.value.email,
                    _uiState.value.password
                )

            _uiState.update {
                it.copy(
                    isLoading = false,
                    isLoggedIn = success
                )
            }
        }
    }
}