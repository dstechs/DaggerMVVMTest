package com.jas.digitalkyats

import android.app.Application


class OkDollarApplication : Application() {
    private var mDaggerComponent: OkDollarComponent? = null

    override fun onCreate() {
        super.onCreate()
        mDaggerComponent = initDaggerComponent()
    }

    fun initDaggerComponent(): OkDollarComponent {
//        return DaggerOkDollarComponent.create()
        return DaggerOkDollarComponent
                .builder()
                .okDollarModule(OkDollarModule(this))
                .networkModule(NetworkModule())
                .build()
    }

    fun getDaggerComponent(): OkDollarComponent? {
        return mDaggerComponent
    }
}