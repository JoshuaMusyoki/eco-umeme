package com.ecoumeme.ecoumeme.common.di

import com.ecoumeme.ecoumeme.data.common.EcoUmemeHttpRepository
import com.ecoumeme.ecoumeme.data.common.EcoUmemeRepository
import com.ecoumeme.ecoumeme.data.common.createHttpClient
import com.ecoumeme.ecoumeme.data.common.localDatabase.LocalStorageRepository
import com.ecoumeme.ecoumeme.data.common.localDatabase.RealmLocalStorageRepositoryImp
import com.ecoumeme.ecoumeme.domain.MainViewModel
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.okhttp.OkHttp
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val module = module {
    single {
        OkHttp.create()
    }

    single {
        createHttpClient(get<HttpClientEngine>())
    }

    single {
        initializeRealmDB()
    }

    singleOf(::RealmLocalStorageRepositoryImp).bind<LocalStorageRepository>()

    singleOf(::EcoUmemeHttpRepository).bind<EcoUmemeRepository>()

    viewModelOf(::MainViewModel)
}