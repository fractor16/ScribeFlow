package com.piyush.scribeflow.domain.repository

import com.piyush.scribeflow.data.local.entity.AppointmentEntity
import kotlinx.coroutines.flow.Flow

interface AppointmentRepository {

    suspend fun saveAppointment(
        appointment: AppointmentEntity
    )

    fun getAppointments():
            Flow<List<AppointmentEntity>>
}