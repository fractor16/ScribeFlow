package com.piyush.scribeflow.presentation.recording

import com.piyush.scribeflow.data.local.entity.RecordingEntity

data class RecordingUiState(

    val isRecording: Boolean = false,

    val recordings: List<RecordingEntity> = emptyList()
)