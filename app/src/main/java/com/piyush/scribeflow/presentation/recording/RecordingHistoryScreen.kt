package com.piyush.scribeflow.presentation.recording

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.piyush.scribeflow.presentation.recording.viewmodel.RecordingViewModel

@Composable
fun RecordingHistoryScreen(
    viewModel: RecordingViewModel = hiltViewModel()
) {

    val uiState =
        viewModel.uiState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = "🎙 Recording History",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        LazyColumn {

            items(
                uiState.value.recordings
            ) { recording ->

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 6.dp)
                ) {

                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {

                        Text(
                            text = recording.filePath
                        )

                        Text(
                            text = recording.createdAt.toString()
                        )
                    }
                }
            }
        }
    }
}