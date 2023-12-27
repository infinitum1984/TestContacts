package com.privat.contacts.presentation.users.model

import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import java.util.function.Consumer

interface UserItemUi {
    fun id(): Int
    fun loadAvatar(imageView: ImageView)
    fun showTitle(textView: TextView)
    fun showText(textView: TextView)
    fun showFavorite(imageButton: ImageButton, clickAction: Consumer<Int>)
}
