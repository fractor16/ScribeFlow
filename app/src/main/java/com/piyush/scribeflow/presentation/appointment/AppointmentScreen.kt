package com.piyush.scribeflow.presentation.appointment

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.piyush.scribeflow.presentation.appointment.viewmodel.AppointmentViewModel

@Composable
fun AppointmentScreen(
    appointmentViewModel: AppointmentViewModel = hiltViewModel()
) {

    val uiState =
        appointmentViewModel.uiState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),

        verticalArrangement = Arrangement.Center
    ) {

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

            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Save Appointment")
        }
    }
}