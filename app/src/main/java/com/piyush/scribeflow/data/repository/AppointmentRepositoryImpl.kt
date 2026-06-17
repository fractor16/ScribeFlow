package com.piyush.scribeflow.data.repository

import com.piyush.scribeflow.data.local.dao.AppointmentDao
import com.piyush.scribeflow.data.local.entity.AppointmentEntity
import com.piyush.scribeflow.domain.repository.AppointmentRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AppointmentRepositoryImpl @Inject constructor(
    private val appointmentDao: AppointmentDao
) : AppointmentRepository {

    override suspend fun saveAppointment(
        appointment: AppointmentEntity
    ) {

        appointmentDao.insertAppointment(
            appointment
        )
    }

    override fun getAppointments():
            Flow<List<AppointmentEntity>> {

        return appointmentDao.getAppointments()
    }
}