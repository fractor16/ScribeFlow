package com.piyush.scribeflow.domain.repository

import com.piyush.scribeflow.data.local.entity.AppointmentEntity
import com.piyush.scribeflow.data.local.relation.AppointmentWithRecordings
import kotlinx.coroutines.flow.Flow

interface AppointmentRepository {

    suspend fun saveAppointment(
        appointment: AppointmentEntity
    )

    fun getAppointments():
            Flow<List<AppointmentEntity>>

    fun getAppointmentWithRecordings(
        appointmentId: Int
    ): Flow<AppointmentWithRecordings>
}