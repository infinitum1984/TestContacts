package com.privat.contacts.presentation.users;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.privat.contacts.databinding.UserItemBinding;
import com.privat.contacts.presentation.users.model.UserItemUi;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.UserViewHolder> {
    private final ArrayList<UserItemUi> userItems = new ArrayList();
    private final Consumer<Integer> favoriteClick;
    private final Consumer<Integer> onClick;
    private final boolean showingFavorite;

    public UsersAdapter(Consumer<Integer> onClick) {
        this.onClick = onClick;
        showingFavorite = false;
        favoriteClick = (id) -> {
        };
    }

    public UsersAdapter(Consumer<Integer> onClick, Consumer<Integer> favoriteClick) {
        this.favoriteClick = favoriteClick;
        this.showingFavorite = true;
        this.onClick = onClick;
    }

    public void updateData(List<UserItemUi> newItems) {
        userItems.clear();
        userItems.addAll(newItems);
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        UserItemBinding binding = UserItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
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
        private final UserItemBinding userItemBinding;

        UserViewHolder(@NonNull UserItemBinding userItemBinding) {
            super(userItemBinding.getRoot());
            this.userItemBinding = userItemBinding;
        }

        void bind(UserItemUi userItemUi) {
            userItemUi.showTitle(userItemBinding.tvName);
            userItemUi.showText(userItemBinding.tvPhone);
            if (showingFavorite)
                userItemUi.showFavorite(userItemBinding.ibFavorite, favoriteClick);
            else
                userItemBinding.ibFavorite.setVisibility(View.GONE);
        }
    }
}
