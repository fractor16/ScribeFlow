package com.piyush.scribeflow.presentation.appointment

import AppRoute
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.piyush.scribeflow.core.ui.components.AppointmentCard
import com.piyush.scribeflow.presentation.appointment.viewmodel.AppointmentViewModel

@Composable
fun AppointmentScreen(
    onAppointmentClick: (Int) -> Unit,
    appointmentViewModel: AppointmentViewModel = hiltViewModel()
) {

    val uiState =
        appointmentViewModel.uiState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(
                rememberScrollState()
            )
            .padding(16.dp)
    )
    {

        Text(
            text = "📅 New Appointment",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        OutlinedTextField(
            value = uiState.value.patientName,
            onValueChange = {
                appointmentViewModel
                    .onPatientNameChange(it)
            },
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text("Patient Name")
            }
        )

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        OutlinedTextField(
            value = uiState.value.appointmentReason,
            onValueChange = {
                appointmentViewModel
                    .onReasonChange(it)
            },
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text("Reason")
            }
        )

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        Button(
            onClick = {
                appointmentViewModel.saveAppointment()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Save Appointment")
        }

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        Text(
            text = "Appointments",
            style = MaterialTheme.typography.titleLarge
        )

        uiState.value.appointments.forEach {

            AppointmentCard(
                patientName = it.patientName,
                reason = it.appointmentReason,
                onClick = {
                    onAppointmentClick(it.id)
                }
            )
        }
    }
}