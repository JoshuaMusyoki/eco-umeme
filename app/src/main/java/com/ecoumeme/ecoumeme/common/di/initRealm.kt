package com.ecoumeme.ecoumeme.common.di

import com.ecoumeme.ecoumeme.data.common.localDatabase.UserDTO
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration

fun initializeRealmDB(): Realm {
    return Realm.open(
        configuration = RealmConfiguration.create(
            schema = setOf(
                UserDTO::class
            )
        )
    )
}