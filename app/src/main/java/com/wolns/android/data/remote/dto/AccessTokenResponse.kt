package com.wolns.android.data.remote.dto

import retrofit2.http.Field

data class AccessTokenResponse(
    @Field("access_token") val accessToken: String
)