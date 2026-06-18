package com.piyush.scribeflow.presentation.appointment.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.piyush.scribeflow.domain.repository.AppointmentRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AppointmentDetailsViewModel @Inject constructor(
    private val repository: AppointmentRepository
) : ViewModel() {

    private val _uiState =
        MutableStateFlow(
            AppointmentDetailsUiState()
        )

    val uiState =
        _uiState.asStateFlow()

    fun loadAppointment(
        appointmentId: Int
    ) {

        viewModelScope.launch {

            repository
                .getAppointmentWithRecordings(
                    appointmentId
                )
                .collect { appointment ->

                    _uiState.value =
                        _uiState.value.copy(
                            appointmentWithRecordings = appointment
                        )
                }
        }
    }
}