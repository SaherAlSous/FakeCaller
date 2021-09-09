package com.saher.fakecaller.util

import com.saher.fakecaller.data.RoomViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.*
import kotlin.math.roundToInt


class Chronometer(roomViewModel: RoomViewModel) {
    private var timer: Timer = Timer()
    var time = roomViewModel.time
    var timerTask = roomViewModel.timerTask
    var timerText = roomViewModel.timerText


    fun timerController(status:Boolean){
        if (status) {
            timerTask = object : TimerTask() {
                override fun run() {
                    CoroutineScope(IO).launch {
                        time++
                        withContext(Main){
                            timerText = getTimerText()
                            updateTime()
                        }
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

    fun updateTime(time:String=timerText):String{
        timerText = time
        println(timerText)
        return timerText
    }
}