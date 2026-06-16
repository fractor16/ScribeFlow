package com.piyush.scribeflow.data.repository

import com.piyush.scribeflow.domain.repository.AuthRepository
import kotlinx.coroutines.delay
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor() : AuthRepository {

    override suspend fun login(
        email: String,
        password: String
    ): Boolean {

        delay(2000)

        return email.isNotBlank()
                && password.isNotBlank()
    }
}