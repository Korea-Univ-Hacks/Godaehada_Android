package com.korea.hacks.util

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.widget.ImageView
import com.bumptech.glide.Glide
import org.jetbrains.annotations.NotNull
import java.io.ByteArrayOutputStream

class ImageUtil {

    companion object {
        fun getBlobFromBitmap(bitmap: Bitmap): ByteArray {
            val stream = ByteArrayOutputStream()
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream)
            return stream.toByteArray()
        }

        fun getBitmapFromBlob(byteArray: ByteArray): Bitmap {
            return BitmapFactory.decodeByteArray(byteArray, 0, byteArray.size)
        }

        fun setImageBitmap(@NotNull view: ImageView, bitmap: Bitmap) {
            Glide.with(view.context)
                .load(bitmap)
                .skipMemoryCache(false)
                .into(view)
        }

        fun setImageUri(@NotNull view: ImageView, uri: Uri?) {
            if (uri != null) {
                Glide.with(view.context)
                    .load(uri)
                    .skipMemoryCache(false)
                    .into(view)
            }
        }

        fun setImageUrl(@NotNull view: ImageView, url: String) {
            if (url.isNotEmpty()) {
                Glide.with(view.context)
                    .load(url)
                    .skipMemoryCache(false)
                    .into(view)
            }
        }
    }
}