package com.wolns.android.data.repositories

import android.app.Application
import android.content.Context
import androidx.core.content.edit
import com.wolns.android.common.AppDispatchers
import com.wolns.android.data.mappers.toDomain
import com.wolns.android.data.remote.api.AccountApiService
import com.wolns.android.data.remote.dto.LoginRequestBody
import com.wolns.android.data.remote.dto.LogupRequestBody
import com.wolns.android.domain.models.LoginResult
import com.wolns.android.domain.models.UserResult
import com.wolns.android.domain.repositories.AccountRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import org.koin.core.annotation.Single

@Single
class AccountRepositoryImpl(
    private val api: AccountApiService,
    private val appDispatchers: AppDispatchers,
    private val app: Application
): AccountRepository {

    private val sp = app.getSharedPreferences(ACCOUNTS_SP, Context.MODE_PRIVATE)

    override suspend fun login(login: String, password: String): Flow<LoginResult> = flow {
        emit(LoginResult.Loading)
        try {
            val token = api.getAccessToken(LoginRequestBody(
                login = login,
                password = password
            )).accessToken
            emit(LoginResult.Success(token))
        } catch (e: Exception) {
            emit(LoginResult.Error(e.message))
        }
    }.flowOn(appDispatchers.io)

    override suspend fun logup(
        name: String, login: String, password: String
    ): Flow<UserResult> = flow {
        emit(UserResult.Loading)
        try {
            val user = api.logup(LogupRequestBody(
                name = name,
                login = login,
                password = password
            ))
            emit(UserResult.Success(user.toDomain()))
        } catch (e: Exception) {
            emit(UserResult.Error(e.message))
        }
    }

    override suspend fun me(token: String): Flow<UserResult> = flow {
        emit(UserResult.Loading)
        try {
            val user = api.me("Bearer $token")
            emit(UserResult.Success(user.toDomain()))
        } catch (e: Exception) {
            emit(UserResult.Error(e.message))
        }
    }

    override suspend fun saveToken(token: String) {
        sp.edit { putString(TOKEN, token) }
    }

    override suspend fun deleteToken() {
        sp.edit { remove(TOKEN) }
    }

    override suspend fun loadToken(): String? = sp.getString(TOKEN, null)

    companion object {
        private const val ACCOUNTS_SP = "accounts"
        private const val TOKEN = "token"
    }
}