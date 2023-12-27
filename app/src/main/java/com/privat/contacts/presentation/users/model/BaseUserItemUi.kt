package com.privat.contacts.presentation.users.model

import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.privat.contacts.R
import java.util.function.Consumer

class BaseUserItemUi(private val id: Int, private val name: String, private val phone: String, private val imgUrl: String) : UserItemUi {
    override fun id(): Int {
        return id
    }

    override fun loadAvatar(imageView: ImageView) {
        Glide.with(imageView.context).load(imgUrl).placeholder(R.drawable.ic_person)
                .into(imageView)
    }

    override fun showTitle(textView: TextView) {
        textView.text = name
    }

    override fun showText(textView: TextView) {
        textView.text = phone
    }

    override fun showFavorite(imageButton: ImageButton, clickAction: Consumer<Int>) {
        imageButton.setImageResource(R.drawable.ic_delete)
        imageButton.setOnClickListener { listener: View? -> clickAction.accept(id) }
    }
}
