package com.piyush.scribeflow.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "appointments")
data class AppointmentEntity(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val patientName: String,

    val appointmentReason: String
)