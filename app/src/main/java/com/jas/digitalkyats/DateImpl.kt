package com.jas.digitalkyats

import java.text.SimpleDateFormat
import java.util.*

class DateImpl(private var mDate: Date = Date()) : DateCallback {
    override fun getCurrentTimeDate(): String {
        return SimpleDateFormat("E, dd-MMM-yyyy HH:mm:ss", Locale.ENGLISH).format(mDate).toString()
    }

    override fun getDate(): Long {
        return mDate.time
    }
}