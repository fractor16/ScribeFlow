package com.piyush.scribeflow.presentation.auth.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.piyush.scribeflow.presentation.auth.LoginUiState
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    var uiState by mutableStateOf(LoginUiState())
        private set

    fun onEmailChange(value: String) {
        uiState = uiState.copy(
            email = value
        )
    }

    fun onPasswordChange(value: String) {
        uiState = uiState.copy(
            password = value
        )
    }

    fun login() {

        viewModelScope.launch {

            uiState = uiState.copy(
                isLoading = true
            )

            delay(2000)

            uiState = uiState.copy(
                isLoading = false,
                isLoggedIn = true
            )
        }
    }
}