package com.piyush.scribeflow.presentation.appointment

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.piyush.scribeflow.presentation.appointment.details.AppointmentDetailsViewModel

@Composable
fun AppointmentDetailsScreen(
    appointmentId: Int,
    viewModel: AppointmentDetailsViewModel =
        hiltViewModel()
) {

    val uiState =
        viewModel.uiState.collectAsState()

    LaunchedEffect(
        appointmentId
    ) {
        viewModel.loadAppointment(
            appointmentId
        )
    }

    val appointment =
        uiState.value
            .appointmentWithRecordings

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = "📅 Appointment Details",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        appointment?.let {

            Text(
                text = it.appointment.patientName,
                style = MaterialTheme.typography.titleLarge
            )

            Text(
                text = it.appointment.appointmentReason
            )

            Spacer(
                modifier = Modifier.height(24.dp)
            )

            Text(
                text = "🎙 Recordings",
                style = MaterialTheme.typography.titleLarge
            )

            Spacer(
                modifier = Modifier.height(12.dp)
            )

            LazyColumn {

                items(
                    it.recordings
                ) { recording ->

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    ) {

                        Text(
                            text =
                            "Recording #${recording.id}",
                            modifier =
                            Modifier.padding(16.dp)
                        )
                    }
                }
            }
        }
    }
}