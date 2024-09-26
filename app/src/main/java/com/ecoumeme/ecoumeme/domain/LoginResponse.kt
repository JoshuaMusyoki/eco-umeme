package com.ecoumeme.ecoumeme.domain

interface LoginResponse

data object NotAttempted: LoginResponse

data object FailedLogin: LoginResponse

data class SuccessLogin(
    val user: User
): LoginResponse