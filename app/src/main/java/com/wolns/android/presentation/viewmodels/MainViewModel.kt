package com.wolns.android.presentation.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wolns.android.common.AppDispatchers
import com.wolns.android.domain.models.LoginResult
import com.wolns.android.domain.models.UserResult
import com.wolns.android.domain.repositories.AccountRepository
import com.wolns.android.presentation.models.AuthState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class MainViewModel(
    private val appDispatchers: AppDispatchers,
    private val accountRepository: AccountRepository
): ViewModel() {
    private val _authState = MutableStateFlow<AuthState?>(null)
    val authState = _authState.asStateFlow()

    init {
        viewModelScope.launch(appDispatchers.io) {
            val token = accountRepository.loadToken()

            if (token == null) {
                _authState.emit(AuthState.NotAuthenticated)
                return@launch
            }

            loadAuthState(token)
        }
    }

    private fun loadAuthState(token: String) {
        viewModelScope.launch(appDispatchers.io) {
            accountRepository.me(token).collectLatest {
                when (it) {
                    is UserResult.Success -> _authState.emit(AuthState.Authenticated(
                        user = it.user,
                        accessToken = token
                    ))
                    else -> _authState.emit(AuthState.NotAuthenticated)
                }
            }
        }
    }

    fun login(login: String, password: String, onLoginResult: (LoginResult) -> Unit) {
        viewModelScope.launch(appDispatchers.io) {
            accountRepository.login(login, password).collectLatest {
                Log.d("test", it.toString())
                when (it) {
                    is LoginResult.Success -> {
                        accountRepository.saveToken(it.accessToken)
                        loadAuthState(it.accessToken)
                    }
                    else -> {}
                }
                onLoginResult(it)
            }
        }
    }

    fun logup(name: String, login: String, password: String, onUserResult: (UserResult) -> Unit) {
        viewModelScope.launch(appDispatchers.io) {
            accountRepository.logup(name, login, password).collectLatest {
                Log.d("test", it.toString())
                onUserResult(it)
            }
        }
    }
}