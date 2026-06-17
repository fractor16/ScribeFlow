package com.piyush.scribeflow.presentation.recording

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import android.Manifest
import android.content.pm.PackageManager
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat
import androidx.hilt.navigation.compose.hiltViewModel
import com.piyush.scribeflow.presentation.recording.viewmodel.RecordingViewModel

@Composable
fun RecordingScreen(
    onOpenHistory: () -> Unit,
    viewModel: RecordingViewModel = hiltViewModel()
) {

    val uiState = viewModel.uiState.collectAsState()

    val context = LocalContext.current

    val permissionLauncher =
        rememberLauncherForActivityResult(
            contract =
            ActivityResultContracts.RequestPermission()
        ) { }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = if (uiState.value.isRecording)
                "🎙 Recording..."
            else
                "Ready To Record",

            style = MaterialTheme.typography.headlineMedium
        )

        Button(
            onClick = {

                if (!uiState.value.isRecording) {

                    if (
                        ContextCompat.checkSelfPermission(
                            context,
                            Manifest.permission.RECORD_AUDIO
                        ) == PackageManager.PERMISSION_GRANTED
                    ) {

                        viewModel.startRecording()



                    } else {

                        permissionLauncher.launch(
                            Manifest.permission.RECORD_AUDIO
                        )
                    }

                } else {

                    viewModel.stopRecording()


                }

            }
        ) {

            Text(
                text = if (uiState.value.isRecording)
                    "Stop Recording"
                else
                    "Start Recording"
            )
        }

        Button(
            onClick = {
                onOpenHistory()
            }
        ) {
            Text("View Recordings")
        }
    }
}