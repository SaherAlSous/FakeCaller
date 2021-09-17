package com.saher.fakecaller.util

import android.content.Context
import android.media.AudioManager
import android.media.MediaPlayer
import android.media.MediaPlayer.create
import android.media.Ringtone
import android.media.RingtoneManager
import android.media.audiofx.Equalizer
import android.media.audiofx.PresetReverb
import android.net.Uri
import android.provider.Settings
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

private const val TAG = "MEDIAPLAYER"

class StartRingTone(context: Context){


    private val uri: Uri = RingtoneManager.getActualDefaultRingtoneUri(context,RingtoneManager.TYPE_RINGTONE)
    private val ringTone: MediaPlayer = MediaPlayer.create(context, uri)
    private var playing = mutableStateOf(true)

    fun startStopRingtone() {
        if (playing.value){
            Log.d(TAG, "Media Player Stopped")
            ringTone.stop()
//            ringTone.release()
//            ringTone.reset()
            playing.value = true

        }else{
            Log.d(TAG, "Media Player Started")
            ringTone.start()
            playing.value = false
        }
    }
}