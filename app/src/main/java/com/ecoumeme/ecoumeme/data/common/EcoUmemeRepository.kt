package com.ecoumeme.ecoumeme.data.common

import com.ecoumeme.ecoumeme.domain.UserDetails

interface EcoUmemeRepository {

    suspend fun postUserDetails(userDetails: UserDetails): Boolean

    suspend fun getUserDetails()
}