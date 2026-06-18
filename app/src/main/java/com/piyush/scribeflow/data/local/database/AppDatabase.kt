package com.piyush.scribeflow.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.piyush.scribeflow.data.local.dao.AppointmentDao
import com.piyush.scribeflow.data.local.dao.RecordingDao
import com.piyush.scribeflow.data.local.entity.AppointmentEntity
import com.piyush.scribeflow.data.local.entity.RecordingEntity

@Database(
    entities = [
        AppointmentEntity::class,
        RecordingEntity::class
    ],
    version = 3,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun recordingDao(): RecordingDao

    abstract fun appointmentDao(): AppointmentDao
}