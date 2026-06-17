package com.piyush.scribeflow.di

import android.content.Context
import androidx.room.Room
import com.piyush.scribeflow.data.local.database.AppDatabase
import com.piyush.scribeflow.data.local.dao.AppointmentDao
import com.piyush.scribeflow.data.local.dao.RecordingDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): AppDatabase {

        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "scribeflow_database"
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun provideAppointmentDao(
        database: AppDatabase
    ): AppointmentDao {

        return database.appointmentDao()
    }

    @Provides
    fun provideRecordingDao(
        database: AppDatabase
    ): RecordingDao {

        return database.recordingDao()
    }
}