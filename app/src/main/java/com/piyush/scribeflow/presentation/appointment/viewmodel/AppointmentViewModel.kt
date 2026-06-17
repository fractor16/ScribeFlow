package com.piyush.scribeflow.presentation.appointment.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.piyush.scribeflow.data.local.entity.AppointmentEntity
import com.piyush.scribeflow.domain.repository.AppointmentRepository
import com.piyush.scribeflow.presentation.appointment.AppointmentUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AppointmentViewModel @Inject constructor(
    private val repository: AppointmentRepository
) : ViewModel() {

    private val _uiState =
        MutableStateFlow(AppointmentUiState())

    val uiState = _uiState.asStateFlow()

    init {

        viewModelScope.launch {

            repository
                .getAppointments()
                .collect { appointments ->

                    _uiState.update {
                        it.copy(
                            appointments = appointments
                        )
                    }
                }
        }
    }

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

    fun saveAppointment() {

        viewModelScope.launch {

            repository.saveAppointment(
                AppointmentEntity(
                    patientName = _uiState.value.patientName,
                    appointmentReason = _uiState.value.appointmentReason
                )
            )

            _uiState.update {
                it.copy(
                    patientName = "",
                    appointmentReason = ""
                )
            }
        }
    }
}