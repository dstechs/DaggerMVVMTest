package com.jas.digitalkyats

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class OkDollarModule(private val okDollarApplication: OkDollarApplication) {
    @Provides
    @Singleton
    fun getDataImpt(): DateImpl {
        return DateImpl()
    }

    @Provides
    fun getApplication(): OkDollarApplication = okDollarApplication

    @Provides
    fun getContext(): Context = okDollarApplication
}