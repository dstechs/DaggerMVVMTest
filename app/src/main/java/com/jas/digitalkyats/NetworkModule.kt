package com.jas.digitalkyats

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Inject

@Module
class NetworkModule {
    @Provides
    @Inject
    fun getStringLocale(mContext: Context, mId: Int): String = mContext.getString(mId)
}