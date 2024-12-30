package com.wolns.android.data.remote.api

import com.wolns.android.data.remote.dto.AccessTokenResponse
import com.wolns.android.data.remote.dto.LoginRequestBody
import com.wolns.android.data.remote.dto.LogupRequestBody
import com.wolns.android.data.remote.dto.UserResponse
import org.koin.core.annotation.Single
import retrofit2.Retrofit
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST

@Single
fun provigeAccountApiService(retrofit: Retrofit): AccountApiService =
    retrofit.create(AccountApiService::class.java)

interface AccountApiService {

    @POST("/api/v1/auth/token")
    @Headers(
        "Content-Type: application/json;charset=utf-8",
        "Accept: application/json",
//        "Accept-Encoding: *"
    )
    suspend fun getAccessToken(@Body body: LoginRequestBody): AccessTokenResponse

    @POST("/api/v1/users")
    @Headers(
        "Content-Type: application/json;charset=utf-8",
        "Accept: application/json",
//        "Accept-Encoding: *"
    )
    suspend fun logup(@Body body: LogupRequestBody): UserResponse

    @GET("/api/v1/users/me")
    suspend fun me(@Header("Authorization") token: String): UserResponse
}