package com.saher.fakecaller.ui.components.contactpage

import PickUp
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import com.saher.fakecaller.R
import dev.chrisbanes.accompanist.glide.GlideImage

var imageUriState = mutableStateOf<Uri?>(null)
val pickingUp = PickUp().pick


@Composable
fun ContactPagePhoto() {

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .layoutId("userPhoto")
            .fillMaxHeight(0.4f)
            .fillMaxWidth(1f)
    ) {
        if (imageUriState.value != null){
            GlideImage(
                modifier = Modifier
                    .fillMaxSize(1f),
                data = imageUriState.value!!,
                contentDescription = "UserImage",
                contentScale = ContentScale.Crop
                )
        }else {
            Image(
                modifier = Modifier.fillMaxSize(1f),
                painter = painterResource(id = R.drawable.yara),
                contentDescription = "Contact Photo",
                contentScale = ContentScale.Crop,
                alignment = Alignment.TopStart,

                )
        }
    }
    TextButton(
        onClick = { pickingUp.launch("image/*") },
        modifier = Modifier.layoutId("changePhoto")
    ) {
        Text(
            text = "Change Photo",
        color = Color.Black)
    }
}

/*
D/EGL_emulation: app_time_stats: avg=766.36ms min=37.81ms max=2100.95ms count=3
E/AndroidRuntime: FATAL EXCEPTION: main
    Process: com.saher.fakecaller, PID: 7958
    java.lang.NullPointerException: Attempt to invoke virtual method 'android.app.ActivityThread$ApplicationThread android.app.ActivityThread.getApplicationThread()' on a null object reference
        at android.app.Activity.startActivityForResult(Activity.java:5405)
        at androidx.activity.ComponentActivity.startActivityForResult(ComponentActivity.java:637)
        at androidx.core.app.ActivityCompat.startActivityForResult(ActivityCompat.java:239)
        at androidx.activity.ComponentActivity$2.onLaunch(ComponentActivity.java:218)
        at androidx.activity.result.ActivityResultRegistry$2.launch(ActivityResultRegistry.java:173)
        at androidx.activity.result.ActivityResultLauncher.launch(ActivityResultLauncher.java:47)
        at com.saher.fakecaller.ui.components.contactpage.ContactPagePhotoKt$ContactPagePhoto$2.invoke(ContactPagePhoto.kt:54)
        at com.saher.fakecaller.ui.components.contactpage.ContactPagePhotoKt$ContactPagePhoto$2.invoke(ContactPagePhoto.kt:54)
        at androidx.compose.foundation.ClickableKt$clickable$4$gesture$1$2.invoke-k-4lQ0M(Clickable.kt:137)
        at androidx.compose.foundation.ClickableKt$clickable$4$gesture$1$2.invoke(Clickable.kt:137)
        at androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapAndPress$2$1$1.invokeSuspend(TapGestureDetector.kt:378)
        at kotlin.coroutines.jvm.internal.BaseContinuationImpl.resumeWith(ContinuationImpl.kt:33)
        at kotlinx.coroutines.DispatchedTaskKt.resume(DispatchedTask.kt:178)
        at kotlinx.coroutines.DispatchedTaskKt.dispatch(DispatchedTask.kt:166)
        at kotlinx.coroutines.CancellableContinuationImpl.dispatchResume(CancellableContinuationImpl.kt:398)
        at kotlinx.coroutines.CancellableContinuationImpl.resumeImpl(CancellableContinuationImpl.kt:432)
        at kotlinx.coroutines.CancellableContinuationImpl.resumeImpl$default(CancellableContinuationImpl.kt:421)
        at kotlinx.coroutines.CancellableContinuationImpl.resumeWith(CancellableContinuationImpl.kt:329)
        at androidx.compose.ui.input.pointer.SuspendingPointerInputFilter$PointerEventHandlerCoroutine.offerPointerEvent(SuspendingPointerInputFilter.kt:432)
        at androidx.compose.ui.input.pointer.SuspendingPointerInputFilter.dispatchPointerEvent(SuspendingPointerInputFilter.kt:330)
        at androidx.compose.ui.input.pointer.SuspendingPointerInputFilter.onPointerEvent-H0pRuoY(SuspendingPointerInputFilter.kt:343)
        at androidx.compose.ui.input.pointer.Node.dispatchMainEventPass(HitPathTracker.kt:287)
        at androidx.compose.ui.input.pointer.Node.dispatchMainEventPass(HitPathTracker.kt:275)
        at androidx.compose.ui.input.pointer.NodeParent.dispatchMainEventPass(HitPathTracker.kt:151)
        at androidx.compose.ui.input.pointer.HitPathTracker.dispatchChanges(HitPathTracker.kt:90)
        at androidx.compose.ui.input.pointer.PointerInputEventProcessor.process-gBdvCQM(PointerInputEventProcessor.kt:77)
        at androidx.compose.ui.platform.AndroidComposeView.dispatchTouchEvent(AndroidComposeView.android.kt:860)
        at android.view.ViewGroup.dispatchTransformedTouchEvent(ViewGroup.java:3120)
        at android.view.ViewGroup.dispatchTouchEvent(ViewGroup.java:2801)
        at android.view.ViewGroup.dispatchTransformedTouchEvent(ViewGroup.java:3120)
        at android.view.ViewGroup.dispatchTouchEvent(ViewGroup.java:2801)
        at android.view.ViewGroup.dispatchTransformedTouchEvent(ViewGroup.java:3120)
        at android.view.ViewGroup.dispatchTouchEvent(ViewGroup.java:2801)
        at android.view.ViewGroup.dispatchTransformedTouchEvent(ViewGroup.java:3120)
        at android.view.ViewGroup.dispatchTouchEvent(ViewGroup.java:2801)
        at com.android.internal.policy.DecorView.superDispatchTouchEvent(DecorView.java:502)
        at com.android.internal.policy.PhoneWindow.superDispatchTouchEvent(PhoneWindow.java:1890)
        at android.app.Activity.dispatchTouchEvent(Activity.java:4196)
        at com.android.internal.policy.DecorView.dispatchTouchEvent(DecorView.java:460)
        at android.view.View.dispatchPointerEvent(View.java:14797)
        at android.view.ViewRootImpl$ViewPostImeInputStage.processPointerEvent(ViewRootImpl.java:6344)
E/AndroidRuntime:     at android.view.ViewRootImpl$ViewPostImeInputStage.onProcess(ViewRootImpl.java:6145)
        at android.view.ViewRootImpl$InputStage.deliver(ViewRootImpl.java:5623)
        at android.view.ViewRootImpl$InputStage.onDeliverToNext(ViewRootImpl.java:5680)
        at android.view.ViewRootImpl$InputStage.forward(ViewRootImpl.java:5646)
        at android.view.ViewRootImpl$AsyncInputStage.forward(ViewRootImpl.java:5811)
        at android.view.ViewRootImpl$InputStage.apply(ViewRootImpl.java:5654)
        at android.view.ViewRootImpl$AsyncInputStage.apply(ViewRootImpl.java:5868)
        at android.view.ViewRootImpl$InputStage.deliver(ViewRootImpl.java:5627)
        at android.view.ViewRootImpl$InputStage.onDeliverToNext(ViewRootImpl.java:5680)
        at android.view.ViewRootImpl$InputStage.forward(ViewRootImpl.java:5646)
        at android.view.ViewRootImpl$InputStage.apply(ViewRootImpl.java:5654)
        at android.view.ViewRootImpl$InputStage.deliver(ViewRootImpl.java:5627)
        at android.view.ViewRootImpl.deliverInputEvent(ViewRootImpl.java:8558)
        at android.view.ViewRootImpl.doProcessInputEvents(ViewRootImpl.java:8509)
        at android.view.ViewRootImpl.enqueueInputEvent(ViewRootImpl.java:8478)
        at android.view.ViewRootImpl$WindowInputEventReceiver.onInputEvent(ViewRootImpl.java:8681)
        at android.view.InputEventReceiver.dispatchInputEvent(InputEventReceiver.java:259)
        at android.os.MessageQueue.nativePollOnce(Native Method)
        at android.os.MessageQueue.next(MessageQueue.java:335)
        at android.os.Looper.loopOnce(Looper.java:161)
        at android.os.Looper.loop(Looper.java:288)
        at android.app.ActivityThread.main(ActivityThread.java:7822)
        at java.lang.reflect.Method.invoke(Native Method)
        at com.android.internal.os.RuntimeInit$MethodAndArgsCaller.run(RuntimeInit.java:548)
        at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:1003)
D/EGL_emulation: app_time_stats: avg=171.18ms min=6.59ms max=2564.27ms count=19
I/Process: Sending signal. PID: 7958 SIG: 9

 */