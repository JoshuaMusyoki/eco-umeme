package com.ecoumeme.ecoumeme.domain

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ecoumeme.ecoumeme.data.common.EcoUmemeRepository
import com.ecoumeme.ecoumeme.data.common.localDatabase.LocalStorageRepository
import com.ecoumeme.ecoumeme.presentation.Routes
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

    private val _recommendationResponse = MutableStateFlow<Boolean?>(null)
    val recommendationResponse: StateFlow<Boolean?> = _recommendationResponse.asStateFlow()

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
            _loginResponse.value = SuccessLogin(user)
        }
    }

    fun loginUser(username: String, password: String) {
        viewModelScope.launch {
            val response = localStorageRepository.login(username = username, password = password)

            _loginResponse.value = response
        }
    }

    fun getRecommendation(
        location: String,
        billMonth1: String,
        billMonth2: String,
        billMonth3: String,
        hasFridge: Boolean,
        hasWasher: Boolean,
        hasAC: Boolean,
        hasCooker: Boolean,
        requestInspection: Boolean,
    ) {
        viewModelScope.launch {
            val user = if (loginResponse.value is SuccessLogin) {
                (loginResponse.value as SuccessLogin).user
            } else {
                null
            }

            user?.let { theUser ->
                ecoUmemeRepository.postUserDetails(
                    UserDetails(
                        name = theUser.name,
                                phone = theUser.phone,
                                email = theUser.email,
                                county = location,
                                bill1 = billMonth1.toInt(),
                                bill2 = billMonth2.toInt(),
                                bill3 = billMonth3.toInt(),
                                fridge = hasFridge,
                                washer = hasWasher,
                                ac = hasAC,
                                ecooker = hasCooker,
                                inspectionrequest = false,
                                inspectiondate = null,
                    )
                )

                _recommendationResponse.value = true
            } ?: run {
                _recommendationResponse.value = false
            }
        }
    }
}