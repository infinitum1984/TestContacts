package com.privat.contacts.presentation.users

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.privat.contacts.databinding.UserItemBinding
import com.privat.contacts.presentation.users.model.UserItemUi
import java.util.function.Consumer

class UsersAdapter : RecyclerView.Adapter<UsersAdapter.UserViewHolder> {
    private val userItems = ArrayList<UserItemUi>()
    private val deleteClick: Consumer<Int>
    private val onClick: Consumer<Int>
    private val showingFavorite: Boolean

    constructor(onClick: Consumer<Int>) {
        this.onClick = onClick
        showingFavorite = false
        deleteClick = Consumer { id: Int? -> }
    }

    constructor(onClick: Consumer<Int>, favoriteClick: Consumer<Int>) {
        deleteClick = favoriteClick
        showingFavorite = true
        this.onClick = onClick
    }

    fun updateData(newItems: List<UserItemUi>) {
        userItems.clear()
        userItems.addAll(newItems)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding = UserItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(userItems[position])
    }

    override fun getItemCount(): Int {
        return userItems.size
    }

    inner class UserViewHolder(private val userItemBinding: UserItemBinding) : RecyclerView.ViewHolder(userItemBinding.root) {
        fun bind(userItemUi: UserItemUi) {
            userItemUi.showTitle(userItemBinding.tvName)
            userItemUi.showText(userItemBinding.tvPhone)
            userItemUi.loadAvatar(userItemBinding.ivAvatar)
            if (showingFavorite) userItemUi.showFavorite(userItemBinding.ibFavorite, deleteClick) else userItemBinding.ibFavorite.visibility = View.GONE
            userItemBinding.root.setOnClickListener { listener: View? -> onClick.accept(userItemUi.id()) }
        }
    }
}
