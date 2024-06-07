package com.si.fanalytics.share_intent

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.core.content.FileProvider
import java.io.File

fun shareImageAndText(context: Context, imageUri: Uri, text: String) {
    val shareIntent: Intent = Intent().apply {
        action = Intent.ACTION_SEND
        putExtra(Intent.EXTRA_TEXT, text)
        putExtra(Intent.EXTRA_STREAM, imageUri)
        type = "image/*"
        addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
    }
    context.startActivity(Intent.createChooser(shareIntent, "Share image and text via"))
}

// Helper function to get Uri for the image file
fun getImageUri(context: Context, imageFile: File): Uri {
    return FileProvider.getUriForFile(context, "${context.packageName}.fileprovider", imageFile)
}
