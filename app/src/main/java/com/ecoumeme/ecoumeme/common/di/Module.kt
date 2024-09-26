package com.ecoumeme.ecoumeme.common.di

import com.ecoumeme.ecoumeme.data.common.createHttpClient
import org.koin.dsl.module

val module = module {
    single {
        createHttpClient(get())
    }
}