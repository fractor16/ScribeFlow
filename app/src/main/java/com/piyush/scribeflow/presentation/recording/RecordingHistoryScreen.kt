package com.piyush.scribeflow.presentation.recording

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.piyush.scribeflow.core.player.AndroidAudioPlayer
import com.piyush.scribeflow.presentation.recording.viewmodel.RecordingViewModel

@Composable
fun RecordingHistoryScreen(
    viewModel: RecordingViewModel = hiltViewModel()
) {

    val playingRecordingId = remember {
        mutableStateOf<Int?>(null)
    }

    val player = remember {
        AndroidAudioPlayer()
    }

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
                            text = "🎙 Recording #${recording.id}",
                            style = MaterialTheme.typography.titleMedium
                        )

                        Spacer(
                            modifier = Modifier.height(8.dp)
                        )

                        Row(
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {

                            Button(
                                onClick = {

                                    playingRecordingId.value = recording.id

                                    player.play(
                                        recording.filePath
                                    )
                                }
                            ) {
                                Text(
                                    if (playingRecordingId.value == recording.id)
                                        "🔊 Playing"
                                    else
                                        "▶ Play"
                                )
                            }

                            Button(
                                onClick = {

                                    player.stop()

                                    playingRecordingId.value = null
                                }
                            ) {
                                Text("⏹ Stop")
                            }
                        }


                        Text(
                            text = "Saved Successfully"
                        )
                    }
                }
            }
        }
    }
}