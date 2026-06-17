package com.piyush.scribeflow.di


import com.piyush.scribeflow.data.repository.AppointmentRepositoryImpl
import com.piyush.scribeflow.data.repository.AuthRepositoryImpl
import com.piyush.scribeflow.data.repository.RecordingRepositoryImpl
import com.piyush.scribeflow.domain.repository.AppointmentRepository
import com.piyush.scribeflow.domain.repository.AuthRepository
import com.piyush.scribeflow.domain.repository.RecordingRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindAuthRepository(
        authRepositoryImpl: AuthRepositoryImpl
    ): AuthRepository

    @Binds
    abstract fun bindAppointmentRepository(
        appointmentRepositoryImpl: AppointmentRepositoryImpl
    ): AppointmentRepository

    @Binds
    abstract fun bindRecordingRepository(
        recordingRepositoryImpl: RecordingRepositoryImpl
    ): RecordingRepository
}