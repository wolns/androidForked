package com.wolns.android.data.mappers

import com.wolns.android.data.remote.dto.UserResponse
import com.wolns.android.domain.models.User

fun UserResponse.toDomain(): User = User(
    name = name,
    login = login,
    uuid = uuid
)