package com.ecoumeme.ecoumeme.data.common.localDatabase

import com.ecoumeme.ecoumeme.domain.LoginResponse
import com.ecoumeme.ecoumeme.domain.User

interface LocalStorageRepository {

    //suspend fun getUserDetails(): User?

    suspend fun saveUserDetails(user: User)

    suspend fun login(username: String, password: String): LoginResponse
}