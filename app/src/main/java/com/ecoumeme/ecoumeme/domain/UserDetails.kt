package com.ecoumeme.ecoumeme.domain

import kotlinx.serialization.Serializable

@Serializable
data class UserDetails(
    val name: String,
    val phone: String,
    val email: String,
    val county: String,
    val bill1: Int,
    val bill2: Int,
    val bill3: Int,
    val fridge: Boolean,
    val washer: Boolean,
    val ac: Boolean,
    val ecooker: Boolean,
    val inspectionrequest: Boolean,
    val inspectiondate: Boolean?,
    val smsstatus: String = "pending", //"pending"


)
