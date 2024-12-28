package com.wolns.android.domain.repositories

import com.wolns.android.domain.models.LoginResult
import com.wolns.android.domain.models.UserResult
import kotlinx.coroutines.flow.Flow

interface AccountRepository {

    suspend fun login(login: String, password: String): Flow<LoginResult>

    suspend fun logup(name: String, login: String, password: String): Flow<UserResult>

    suspend fun me(token: String): Flow<UserResult>

    suspend fun saveToken(token: String)

    suspend fun deleteToken()

    suspend fun loadToken(): String?
}