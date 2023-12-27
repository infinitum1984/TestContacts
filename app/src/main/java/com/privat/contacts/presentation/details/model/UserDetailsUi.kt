package com.privat.contacts.presentation.details.model

import android.widget.ImageView
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton

interface UserDetailsUi {
    fun showName(textView: TextView)
    fun showPhone(textView: TextView)
    fun loadAvatar(imageView: ImageView)
    fun showFavorite(floatingActionButton: FloatingActionButton)
}
