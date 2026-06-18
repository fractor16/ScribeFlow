package com.piyush.scribeflow.presentation.appointment.details

import com.piyush.scribeflow.data.local.relation.AppointmentWithRecordings

data class AppointmentDetailsUiState(

    val appointmentWithRecordings:
    AppointmentWithRecordings? = null
)