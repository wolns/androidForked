package com.wolns.android.domain.models

sealed class LoginResult {
    object Empty : LoginResult()
    object Loading : LoginResult()
    data class Success(val accessToken: String) : LoginResult()
    data class Error(val message: String? = null) : LoginResult()
}