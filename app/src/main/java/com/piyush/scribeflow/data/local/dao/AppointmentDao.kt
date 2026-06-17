package com.piyush.scribeflow.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.piyush.scribeflow.data.local.entity.AppointmentEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface AppointmentDao {

    @Insert
    suspend fun insertAppointment(
        appointment: AppointmentEntity
    )

    @Query("SELECT * FROM appointments")
    fun getAppointments(): Flow<List<AppointmentEntity>>
}