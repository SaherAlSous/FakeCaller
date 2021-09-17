package com.saher.fakecaller.util

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.*
import kotlin.math.roundToInt



class Chronometer {
    private var timer: Timer = Timer()
    var time = 0.0
    private var timerTask: TimerTask? = null
    var chronometerTimerText = MutableLiveData("")

    fun timerController(status:Boolean){
        if (status) {
            timerTask =  object : TimerTask() {
                override fun run() {
                    CoroutineScope(IO).launch {
                        time++
                        withContext(Main){
                            chronometerTimerText.value = getTimerText()
                        }
                        updateTime()
                    }
                }
            }
            timer.scheduleAtFixedRate(timerTask, 0, 1000)
        }else{
            timerTask?.cancel()
        }
    }

    @JvmName("getTimerText1")
    private fun getTimerText(): String {
        val rounded = time.roundToInt()
        val seconds = rounded % 86400 % 3600 % 60
        val minutes = rounded % 86400 % 3600 / 60
        val hours = rounded % 86400 / 3600
        return formatTime(seconds, minutes, hours)
    }

    private fun formatTime(seconds: Int, minutes: Int, hours: Int): String {
        return String.format("%02d", hours) + " : " + String.format("%02d", minutes) + " : " + String.format("%02d", seconds)
    }

    fun updateTime(time:String=chronometerTimerText.value!!):String{
        println(time)
        return time
    }
}