package com.jas.digitalkyats

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.jas.digitalkyats.databinding.ActivityLauncherBinding
import com.jas.digitalkyats.observedemo.UserDataRepository
import java.util.*

@SuppressLint("SetTextI18n")
class LauncherActivity : AppCompatActivity(), Observer {
    override fun update(mObserver: Observable?, mData: Any?) {
//        if (mObserver is UserDataRepository)
//            tvDaggerTest.text = "${tvDaggerTest.text}\nData Update\n${mObserver.getName()}----${mObserver.getTitle()}"
    }

//    @Inject
//    lateinit var mDateImpl: DateImpl
//
//    @Inject
//    lateinit var mGetString: String

    var mDataRepositiry: UserDataRepository = UserDataRepository.getInstance()!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_launcher)
        (application as OkDollarApplication).getDaggerComponent()!!.inject(this)

        val binding: ActivityLauncherBinding = DataBindingUtil.setContentView(this, R.layout.activity_launcher)

//        mApplication.getDaggerComponent()!!.inject(this)

        //tvDaggerTest.text = "${mDateImpl.getDate()}\n${mDateImpl.getCurrentTimeDate()}"

        mDataRepositiry.addObserver(this)
        mDataRepositiry.getNameFromServer()

        // Handler().postDelayed({ startActivity(Intent(this, MainActivity::class.java)) }, 3000)
    }

    override fun onDestroy() {
        super.onDestroy()
        mDataRepositiry.deleteObserver(this)
    }

}
