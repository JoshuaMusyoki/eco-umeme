package com.ecoumeme.ecoumeme.data.common

interface EcoUmemeRepository {

    suspend fun postUserDetails()

    suspend fun getUserDetails()
}