package com.privat.contacts.data.cache.photos

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.util.Log
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import io.reactivex.Completable
import io.reactivex.CompletableEmitter
import java.io.BufferedOutputStream
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import javax.inject.Inject

class BasePhotosDatasource @Inject constructor(private val context: Context) : PhotosDatasource {
    override fun savePhoto(userId: Int, photoUrl: String): Completable {
        return Completable.create { subscriber: CompletableEmitter ->
            Glide.with(context)
                    .asBitmap()
                    .load(photoUrl)
                    .diskCacheStrategy(DiskCacheStrategy.NONE)
                    .into(object : CustomTarget<Bitmap>(SIZE_ORIGINAL, SIZE_ORIGINAL) {
                        override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                            try {
                                val fos = FileOutputStream(createImageFile(userId))
                                val bos = BufferedOutputStream(fos)
                                resource.compress(Bitmap.CompressFormat.JPEG, 100, bos)
                                bos.close()
                            } catch (e: IOException) {
                                subscriber.onError(e)
                            }
                            subscriber.onComplete()                        }

                        override fun onLoadCleared(placeholder: Drawable?) {
                        }
                    })
        }
    }

    @Throws(IOException::class)
    private fun createImageFile(userId: Int): File {
        val storageDir = File(context.externalCacheDir, "images")
        if (!storageDir.exists()) storageDir.mkdirs()
        val photoFile = File(
                storageDir, "$userId.png"
        )
        Log.d("D_BasePhotoMaker", "createImageFile: \${photoFile.path}")
        return photoFile
    }

    @Throws(IOException::class)
    override fun removePhoto(userId: Int) {
        createImageFile(userId).delete()
    }
}
