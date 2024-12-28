package com.wolns.android.presentation.models

import com.wolns.android.domain.models.User

sealed class AuthState {
    object NotAuthenticated : AuthState()
    data class Authenticated(
        val user: User,
        val accessToken: String
    ) : AuthState()
}
