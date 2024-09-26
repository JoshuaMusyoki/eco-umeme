package com.ecoumeme.ecoumeme.data.common

import kotlinx.serialization.Serializable

@Serializable
data class BackendResponse(
    val message: String
)