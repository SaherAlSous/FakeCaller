package com.saher.fakecaller.ui.components.settings

import android.content.Context
import android.net.Uri
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.saher.fakecaller.data.RoomViewModel
import com.saher.fakecaller.data.ringtone.RingTone
import com.saher.fakecaller.util.getFileNameWithExtension
import rememberGetContentActivityResult
import java.util.*



@Composable
fun ChoosingRingTone(roomViewModel: RoomViewModel,context: Context) {
    val fileUri = roomViewModel.ringTone
    ObserveRingTone(roomViewModel)
    val getContent = rememberGetContentActivityResult()
    Box(contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()) {
        Column {
            if (fileUri != null && getContent.uri == null){
                fileUri.uri.let { ringtone ->
                    Text(
                        text = fileNameAndSaveUri(it = ringtone,context= context,roomViewModel=roomViewModel),
                        textAlign = TextAlign.Center,
                        fontSize = 24.sp,
                    )
                }
            }else{
                getContent.uri.let { ringtone ->
                    Text(
                        text = fileNameAndSaveUri(it = ringtone,context= context,roomViewModel=roomViewModel),
                        textAlign = TextAlign.Center,
                        fontSize = 24.sp,
                    )
                }
            }
            Button(onClick = { getContent.launch("audio/*")}) {
                Text(text = "Choose RingTone")
            }
        }
    }
}

@Composable
fun fileNameAndSaveUri(it: Uri?,  context: Context, roomViewModel: RoomViewModel): String {
    return if (it != null) {
        SaveUri(it, roomViewModel)
        ObserveRingTone(roomViewModel)
        it.getFileNameWithExtension(context)!!
    }
    else {
        " Choose Ringtone"
    }
}
@Composable
fun SaveUri(it: Uri, roomViewModel: RoomViewModel) {
    val fileUri = roomViewModel.ringTone
    if (fileUri == null){
        val ringtone = RingTone(UUID.randomUUID(), it)
        roomViewModel.insertUri(ringtone)
        println("Ringtone insert condition")
    }else {
            val ringtone = RingTone(fileUri.id, it)
            roomViewModel.updateUri(ringtone)
            println("Ringtone Updated")
    }
}
@Composable
fun ObserveRingTone(roomViewModel: RoomViewModel){

    roomViewModel.readFileUri.observe(
        LocalLifecycleOwner.current
    ) {
        roomViewModel.ringTone = it
    }
}