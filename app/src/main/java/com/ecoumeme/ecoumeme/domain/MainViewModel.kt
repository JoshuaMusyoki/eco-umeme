package com.ecoumeme.ecoumeme.domain

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ecoumeme.ecoumeme.data.common.EcoUmemeRepository
import com.ecoumeme.ecoumeme.data.common.localDatabase.LocalStorageRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel(
    private val localStorageRepository: LocalStorageRepository,
    private val ecoUmemeRepository: EcoUmemeRepository
): ViewModel() {

    init {

    }

    private val _user = MutableStateFlow<User?>(null)
    val user: StateFlow<User?> = _user.asStateFlow()

    private val _loginResponse = MutableStateFlow<LoginResponse>(NotAttempted)
    val loginResponse: StateFlow<LoginResponse> = _loginResponse.asStateFlow()

    fun createUser(username: String, phone: String, email: String, password: String) {
        viewModelScope.launch {
            val user = User(
                name = username,
                phone = phone,
                email = email,
                password = password,
            )
            localStorageRepository.saveUserDetails(user)
            _user.value = user
        }
    }

    fun loginUser(username: String, password: String) {
        viewModelScope.launch {
            val response = localStorageRepository.login(username = username, password = password)

            _loginResponse.value = response
        }
    }

}