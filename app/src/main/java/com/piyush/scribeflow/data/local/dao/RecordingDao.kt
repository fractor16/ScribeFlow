package com.piyush.scribeflow.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.piyush.scribeflow.data.local.entity.RecordingEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface RecordingDao {

    @Insert
    suspend fun insertRecording(
        recording: RecordingEntity
    )

    @Query("SELECT * FROM recordings ORDER BY createdAt DESC")
    fun getRecordings():
            Flow<List<RecordingEntity>>
}