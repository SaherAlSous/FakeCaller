package com.saher.fakecaller.util

import android.media.MediaPlayer
import android.util.Log

private const val TAG = "MEDIAPLAYER"

class StartRingTone(){
    fun startStopRingtone(ringTone:MediaPlayer? ,playing:Boolean) {
        if (playing){
            Log.d(TAG, "Media Player Started")
            ringTone?.start()
        }else{
            Log.d(TAG, "Media Player Stopped")
            ringTone?.stop()
            ringTone?.reset()
            ringTone?.release()
        }
    }
}