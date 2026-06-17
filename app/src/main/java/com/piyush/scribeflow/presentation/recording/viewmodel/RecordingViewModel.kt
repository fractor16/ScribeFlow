package com.piyush.scribeflow.presentation.recording.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.piyush.scribeflow.core.recorder.AndroidAudioRecorder
import com.piyush.scribeflow.data.local.entity.RecordingEntity
import com.piyush.scribeflow.domain.repository.RecordingRepository
import com.piyush.scribeflow.presentation.recording.RecordingUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecordingViewModel @Inject constructor(

    @ApplicationContext
    private val context: Context,

    private val recordingRepository: RecordingRepository

) : ViewModel() {

    private val recorder = AndroidAudioRecorder()

    private var audioFilePath: String? = null

    private val _uiState =
        MutableStateFlow(RecordingUiState())

    val uiState =
        _uiState.asStateFlow()

    init {

        viewModelScope.launch {

            recordingRepository
                .getRecordings()
                .collect { recordings ->

                    _uiState.update {

                        it.copy(
                            recordings = recordings
                        )
                    }
                }
        }
    }

    fun startRecording() {

        audioFilePath =
            "${context.filesDir}/recording_${System.currentTimeMillis()}.m4a"

        recorder.start(
            audioFilePath!!
        )

        _uiState.update {
            it.copy(
                isRecording = true
            )
        }
    }

    fun stopRecording() {

        recorder.stop()

        _uiState.update {
            it.copy(
                isRecording = false
            )
        }

        viewModelScope.launch {

            audioFilePath?.let {

                recordingRepository.saveRecording(

                    RecordingEntity(
                        filePath = it,
                        createdAt = System.currentTimeMillis()
                    )
                )
            }
        }
    }
}