package com.ecoumeme.ecoumeme

import android.app.Application
import com.ecoumeme.ecoumeme.common.di.initKoin

class ApplicationClass: Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin(this@ApplicationClass)
    }
}