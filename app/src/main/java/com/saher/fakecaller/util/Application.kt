package com.saher.fakecaller.util

import android.app.Application
import com.saher.fakecaller.data.Repository

class Application:Application() {
    override fun onCreate() {
        super.onCreate()
        Repository.initialize(this)
    }
}