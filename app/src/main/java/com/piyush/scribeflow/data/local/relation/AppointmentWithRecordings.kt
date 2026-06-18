package com.piyush.scribeflow.data.local.relation

import androidx.room.Embedded
import androidx.room.Relation
import com.piyush.scribeflow.data.local.entity.AppointmentEntity
import com.piyush.scribeflow.data.local.entity.RecordingEntity

data class AppointmentWithRecordings(

    @Embedded
    val appointment: AppointmentEntity,

    @Relation(
        parentColumn = "id",
        entityColumn = "appointmentId"
    )
    val recordings: List<RecordingEntity>
)