package com.saher.fakecaller.util

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.saher.fakecaller.data.RoomViewModel

class RoomViewModelFactory(
    private val application: Application,
    private val startRingTone: StartRingTone,
    private val chronos: Chronometer
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        if (modelClass.isAssignableFrom(RoomViewModel::class.java)) {
            return RoomViewModel(application,startRingTone,chronos) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}