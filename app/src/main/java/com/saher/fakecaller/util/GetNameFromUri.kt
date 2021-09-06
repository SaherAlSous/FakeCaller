package com.saher.fakecaller.util

import android.content.ContentResolver
import android.content.Context
import android.net.Uri
import android.webkit.MimeTypeMap
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.toLowerCase
import java.io.File

fun Uri.getFileNameWithExtension(context: Context): String? {
    val name = this.path?.let { path -> File(path).name }.orEmpty()
    val extension = MimeTypeMap.getSingleton()
        .getExtensionFromMimeType(getMimeType(context)).orEmpty()

    return if (name.isNotEmpty() && extension.isNotEmpty()) "$name.$extension" else null
}

fun Uri.getMimeType(context: Context): String? {
    return when (scheme) {
        ContentResolver.SCHEME_CONTENT -> context.contentResolver.getType(this)
        ContentResolver.SCHEME_FILE -> MimeTypeMap.getSingleton().getMimeTypeFromExtension(
            MimeTypeMap.getFileExtensionFromUrl(toString()).toLowerCase(Locale.current)
        )
        else -> null
    }
}