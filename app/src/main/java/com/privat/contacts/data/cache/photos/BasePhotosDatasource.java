package com.privat.contacts.data.cache.photos;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.inject.Inject;

import io.reactivex.Completable;

public class BasePhotosDatasource implements PhotosDatasource {
    private final Context context;

    @Inject
    public BasePhotosDatasource(Context context) {
        this.context = context;
    }

    @Override
    public Completable savePhoto(int userId, String photoUrl) {
        return Completable.create(subscriber -> {
            Glide.with(context)
                    .asBitmap()
                    .load(photoUrl)
                    .diskCacheStrategy(DiskCacheStrategy.NONE)
                    .into(new CustomTarget<Bitmap>(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL) {
                        @Override
                        public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition transition) {
                            try {
                                FileOutputStream fos = new FileOutputStream(createImageFile(userId));
                                BufferedOutputStream bos = new BufferedOutputStream(fos);
                                resource.compress(Bitmap.CompressFormat.JPEG, 100, bos);
                                bos.close();
                            } catch (IOException e) {
                                subscriber.onError(e);
                            }
                            subscriber.onComplete();

                        }

                        @Override
                        public void onLoadCleared(@Nullable Drawable placeholder) {
                        }
                    });
        });


    }

    @NonNull
    private File createImageFile(int userId) throws IOException {
        File storageDir = new File(context.getExternalCacheDir(), "images");
        if (!storageDir.exists())
            storageDir.mkdirs();
        File photoFile = new File(
                storageDir, userId + ".png"
        );
        Log.d("D_BasePhotoMaker", "createImageFile: ${photoFile.path}");
        return photoFile;
    }

    @Override
    public void removePhoto(int userId) throws IOException {
        createImageFile(userId).delete();
    }
}
