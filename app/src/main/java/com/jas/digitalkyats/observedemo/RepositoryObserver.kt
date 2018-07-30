package com.jas.digitalkyats.observedemo

interface RepositoryObserver {
    fun onUserDataChanged(mName: String, mTitle: String)
}