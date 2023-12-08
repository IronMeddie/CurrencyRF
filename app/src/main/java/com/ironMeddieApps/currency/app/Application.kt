package com.ironMeddieApps.currency.app

import android.app.Application
import com.google.firebase.FirebaseApp
import com.ironmeddieapps.analitics.Analitics
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
open class App: Application(){

    override fun onCreate() {
        super.onCreate()
        Analitics.initAnalitics(this)


    }


}