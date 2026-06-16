package com.piyush.scribeflow.presentation.auth

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.piyush.scribeflow.presentation.auth.viewmodel.LoginViewModel
import androidx.compose.runtime.collectAsState

@Composable
fun LoginScreen(
    onLoginSuccess: () -> Unit,
    loginViewModel: LoginViewModel = hiltViewModel()
) {
    val uiState = loginViewModel.uiState.collectAsState()
    if (uiState.value.isLoggedIn) {
        onLoginSuccess()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),

        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "MediScribe AI"
        )

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        OutlinedTextField(
            value = uiState.value.email,
            onValueChange = {
                loginViewModel.onEmailChange(it)
            },
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text("Email")
            }
        )

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        OutlinedTextField(
            value = uiState.value.password,
            onValueChange = {
                loginViewModel.onPasswordChange(it)
            },
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text("Password")
            }
        )

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        Button(
            onClick = {
                loginViewModel.login()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                if (uiState.value.isLoading)
                    "Loading..."
                else
                    "Login"
            )
        }
    }
}