package com.jas.digitalkyats.observedemo

interface Subject {
    fun registerObserver(mRepositoryObserver: RepositoryObserver)
    fun removeObserver(mRepositoryObserver: RepositoryObserver)
    fun notifyObservers()
}