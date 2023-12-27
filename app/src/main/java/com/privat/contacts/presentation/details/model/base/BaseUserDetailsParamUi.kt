package com.privat.contacts.presentation.details.model.base

import android.net.Uri
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.privat.contacts.R
import com.privat.contacts.presentation.details.model.UserDetailsUi
import java.io.File

class BaseUserDetailsParamUi(private val userId: Int, private val name: String, private val phone: String, private val favorite: Boolean) : UserDetailsUi {
    override fun showName(textView: TextView) {
        textView.text = name
    }

    override fun showPhone(textView: TextView) {
        textView.text = phone
    }

    override fun loadAvatar(imageView: ImageView) {
        val storageDir = File(imageView.context.externalCacheDir, "images")
        val imgFile = File(storageDir, "$userId.png")
        Glide.with(imageView.context).load(Uri.fromFile(imgFile)).placeholder(R.drawable.ic_person).into(imageView)
    }

    override fun showFavorite(floatingActionButton: FloatingActionButton) {
        if (favorite) floatingActionButton.setImageResource(R.drawable.ic_favorite) else floatingActionButton.setImageResource(R.drawable.ic_favorite_border)
    }
}
