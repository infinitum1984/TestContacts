package com.privat.contacts.presentation.details;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.privat.contacts.databinding.UserItemBinding;
import com.privat.contacts.databinding.UserParamItemBinding;
import com.privat.contacts.presentation.details.model.UserDetailsParamUi;
import com.privat.contacts.presentation.users.model.UserItemUi;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class UserParamsAdapter extends RecyclerView.Adapter<UserParamsAdapter.UserViewHolder> {
    private final ArrayList<UserDetailsParamUi> userItems = new ArrayList();
    public void updateData(List<UserDetailsParamUi> newItems) {
        userItems.clear();
        userItems.addAll(newItems);
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        UserParamItemBinding binding = UserParamItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new UserViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        holder.bind(userItems.get(position));
    }

    @Override
    public int getItemCount() {
        return userItems.size();
    }

    class UserViewHolder extends RecyclerView.ViewHolder {
        private final UserParamItemBinding userItemBinding;

        UserViewHolder(@NonNull UserParamItemBinding userItemBinding) {
            super(userItemBinding.getRoot());
            this.userItemBinding = userItemBinding;
        }

        void bind(UserDetailsParamUi userItemUi) {
            userItemUi.showParam(userItemBinding.tvName);
        }
    }
}
