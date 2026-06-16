package com.piyush.scribeflow.presentation.appointment.viewmodel

import androidx.lifecycle.ViewModel
import com.piyush.scribeflow.presentation.appointment.AppointmentUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class AppointmentViewModel : ViewModel() {

    private val _uiState =
        MutableStateFlow(AppointmentUiState())

    val uiState = _uiState.asStateFlow()

    fun onPatientNameChange(value: String) {
        _uiState.update {
            it.copy(
                patientName = value
            )
        }
    }

    fun onReasonChange(value: String) {
        _uiState.update {
            it.copy(
                appointmentReason = value
            )
        }
    }
}