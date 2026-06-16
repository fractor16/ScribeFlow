package com.piyush.scribeflow.presentation.dashboard

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.piyush.scribeflow.core.ui.components.ActivityCard
import com.piyush.scribeflow.core.ui.components.HeroCard
import com.piyush.scribeflow.core.ui.components.StatCard

@Composable
fun DashboardScreen(
    onCreateAppointment: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(
                rememberScrollState()
            )
            .padding(16.dp)
    ) {

        Text(
            text = "👋 Good Morning, Dr. Piyush",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(
            modifier = Modifier.height(8.dp)
        )

        Text(
            text = "AI Clinical Documentation Assistant",
            style = MaterialTheme.typography.bodyLarge
        )

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        HeroCard(
            onStartRecording = {

            }
        )

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        Row(
            modifier = Modifier.fillMaxWidth()
        ) {

            StatCard(
                title = "Appointments",
                value = "12",
                modifier = Modifier.weight(1f)
            )

            Spacer(
                modifier = Modifier.width(12.dp)
            )

            StatCard(
                title = "Charts",
                value = "156",
                modifier = Modifier.weight(1f)
            )
        }

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        StatCard(
            title = "Recordings",
            value = "42",
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        Text(
            text = "⚡ Quick Actions",
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        Button(
            onClick = {
                onCreateAppointment()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("📅 New Appointment")
        }

        Spacer(
            modifier = Modifier.height(12.dp)
        )

        Button(
            onClick = {

            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("🎙 Start Recording")
        }

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        Text(
            text = "📄 Recent Activity",
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(
            modifier = Modifier.height(12.dp)
        )

        ActivityCard(
            title = "Patient summary generated"
        )

        ActivityCard(
            title = "Recording uploaded"
        )

        ActivityCard(
            title = "Chart completed"
        )

        Spacer(
            modifier = Modifier.height(24.dp)
        )
    }
}