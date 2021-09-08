package com.saher.fakecaller.util

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import android.net.Uri
import coil.ImageLoader
import coil.annotation.ExperimentalCoilApi
import coil.request.ImageRequest


suspend fun convertToBitmap(uri: Uri, context: Context, widthPixels: Int, heightPixels: Int): Bitmap? {
    val mutableBitmap = Bitmap.createBitmap(widthPixels, heightPixels, Bitmap.Config.ARGB_8888)
    val canvas = Canvas(mutableBitmap)
    val drawable = getDrawable(uri, context)
    drawable?.setBounds(0, 0, widthPixels, heightPixels)
    drawable?.draw(canvas)
    return mutableBitmap
}


@OptIn(ExperimentalCoilApi::class)
suspend fun getDrawable(uri: Uri, context: Context): Drawable? {
    val imageLoader = ImageLoader.Builder(context)
        .availableMemoryPercentage(0.25)
        .allowHardware(false)
        .crossfade(true)
        .build()

    val request= ImageRequest.Builder(context)
        .data(uri)
        .build()
    return imageLoader.execute(request).drawable
}

