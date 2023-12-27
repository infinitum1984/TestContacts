package com.privat.contacts.presentation.details

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.privat.contacts.databinding.UserParamItemBinding
import com.privat.contacts.presentation.details.model.UserDetailsParamUi

class UserParamsAdapter : RecyclerView.Adapter<UserParamsAdapter.UserViewHolder>() {
    private val userItems: ArrayList<UserDetailsParamUi> = ArrayList()
    fun updateData(newItems: List<UserDetailsParamUi>) {
        userItems.clear()
        userItems.addAll(newItems)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding = UserParamItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(userItems[position]!!)
    }

    override fun getItemCount(): Int {
        return userItems.size
    }

    inner class UserViewHolder(private val userItemBinding: UserParamItemBinding) : RecyclerView.ViewHolder(userItemBinding.root) {
        fun bind(userItemUi: UserDetailsParamUi) {
            userItemUi.showParam(userItemBinding.tvName)
        }
    }
}
