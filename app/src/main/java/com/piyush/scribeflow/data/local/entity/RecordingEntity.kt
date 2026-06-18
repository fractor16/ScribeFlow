package com.piyush.scribeflow.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "recordings"
)
data class RecordingEntity(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val appointmentId: Int,

    val filePath: String,

    val createdAt: Long
)