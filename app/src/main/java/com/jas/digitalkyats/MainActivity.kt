package com.jas.digitalkyats

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.jas.digitalkyats.observedemo.UserDataRepository
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

@SuppressLint("SetTextI18n")
class MainActivity : AppCompatActivity(), Observer {
    override fun update(mObservable: Observable?, mData: Any?) {
        if (mObservable is UserDataRepository) {
            tvMainText.text = "${tvMainText.text}\nData Update\n${mObservable.getName()}----${mObservable.getTitle()}"
        }
    }

    var mDataRepository: UserDataRepository = UserDataRepository.getInstance()!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mDataRepository.addObserver(this)
        tvMainText.text = "${mDataRepository.getName()}  ${mDataRepository.getTitle()}"
        tvMainText.setOnClickListener({ "Dinesh" })
        Handler().postDelayed({ mDataRepository.setUserData("OkDollar", "Observer") }, 2000)
    }

    override fun onDestroy() {
        super.onDestroy()
        mDataRepository.deleteObserver(this)
    }

}
