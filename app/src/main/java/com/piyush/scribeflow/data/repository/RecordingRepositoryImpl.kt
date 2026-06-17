package com.piyush.scribeflow.data.repository

import com.piyush.scribeflow.data.local.dao.RecordingDao
import com.piyush.scribeflow.data.local.entity.RecordingEntity
import com.piyush.scribeflow.domain.repository.RecordingRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RecordingRepositoryImpl @Inject constructor(
    private val recordingDao: RecordingDao
) : RecordingRepository {

    override suspend fun saveRecording(
        recording: RecordingEntity
    ) {

        recordingDao.insertRecording(
            recording
        )
    }

    override fun getRecordings():
            Flow<List<RecordingEntity>> {

        return recordingDao.getRecordings()
    }
}