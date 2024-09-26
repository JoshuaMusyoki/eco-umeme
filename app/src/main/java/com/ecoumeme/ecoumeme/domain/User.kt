package com.ecoumeme.ecoumeme.domain

data class User(
    var name: String,
    var phone: String,
    var email: String,
    val password: String
)
