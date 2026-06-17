package com.piyush.scribeflow.presentation.appointment

import com.piyush.scribeflow.data.local.entity.AppointmentEntity

data class AppointmentUiState(

    val patientName: String = "",

    val appointmentReason: String = "",

    val appointments: List<AppointmentEntity> = emptyList()
)