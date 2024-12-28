package com.wolns.android.domain.models

sealed class UserResult {
    object Empty : UserResult()
    object Loading : UserResult()
    data class Success(val user: User) : UserResult()
    data class Error(val message: String? = null) : UserResult()
}