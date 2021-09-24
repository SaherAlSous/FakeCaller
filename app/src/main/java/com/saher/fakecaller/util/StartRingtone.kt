package com.saher.fakecaller.util

import android.media.MediaPlayer
import android.util.Log
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

private const val TAG = "MEDIAPLAYER"

@ViewModelScoped
open class StartRingTone @Inject constructor() {

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