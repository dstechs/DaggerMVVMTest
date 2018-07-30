package com.jas.digitalkyats

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [OkDollarModule::class, NetworkModule::class])
interface OkDollarComponent {
    fun inject(mLauncher: LauncherActivity)
}