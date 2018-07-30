package com.jas.digitalkyats

import android.content.Context
import javax.inject.Inject

class StringLocalization {
    @Inject
    lateinit var mContext: Context

    fun getStringLocalization(mId: Int): String {
        return mContext.getString(mId)
    }
}