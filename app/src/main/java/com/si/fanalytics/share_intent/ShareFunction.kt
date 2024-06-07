package com.si.fanalytics.share_intent

import android.content.Context
import android.content.Intent
import android.net.Uri

fun shareImageAndText(context: Context, imageUri: Uri, text: String) {
    val shareIntent: Intent = Intent().apply {
        action = Intent.ACTION_SEND
        putExtra(Intent.EXTRA_TEXT, text)
        putExtra(Intent.EXTRA_STREAM, imageUri)
        type = "image/*"
        addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
    }
    context.startActivity(Intent.createChooser(shareIntent, "Share image and text"))
}