package com.jas.digitalkyats.observedemo

import android.os.Handler
import java.util.*

class UserDataRepository : Observable() {
    //    private var observerList: MutableList<RepositoryObserver>? = null
    private var mName: String = "Hi"
    private var mTitle: String = " Guest!"

    init {
//        observerList = arrayListOf()
    }

    companion object {
        private val mInstance: UserDataRepository? = UserDataRepository()
        fun getInstance(): UserDataRepository? {
            return mInstance
        }
    }

    fun getNameFromServer() {
        Handler().postDelayed({ setUserData("Dinesh", "Singh") }, 1500)
    }

    fun setUserData(mName: String, mTitle: String) {
        this.mName = mName
        this.mTitle = mTitle
        setChanged()
        notifyObservers()
    }

    fun getName(): String = mName

    fun getTitle(): String = mTitle

//    override fun removeObserver(mRepositoryObserver: RepositoryObserver) {
//        if (mRepositoryObserver in observerList!!)
//            observerList!!.remove(mRepositoryObserver)
//    }
//
//    override fun notifyObservers() {
//        for (mRepositionObserver in observerList!!)
//            mRepositionObserver.onUserDataChanged(mName, mTitle)
//    }
//
//    override fun registerObserver(mRepositoryObserver: RepositoryObserver) {
//        if (mRepositoryObserver !in observerList!!)
//            observerList!!.add(mRepositoryObserver)
//    }
}