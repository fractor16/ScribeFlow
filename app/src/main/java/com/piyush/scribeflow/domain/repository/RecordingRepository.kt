package com.piyush.scribeflow.domain.repository

import com.piyush.scribeflow.data.local.entity.RecordingEntity
import kotlinx.coroutines.flow.Flow

interface RecordingRepository {

    suspend fun saveRecording(
        recording: RecordingEntity
    )

    fun getRecordings():
            Flow<List<RecordingEntity>>
}