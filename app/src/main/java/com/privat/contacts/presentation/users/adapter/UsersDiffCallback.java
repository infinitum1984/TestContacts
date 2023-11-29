package com.privat.contacts.presentation.users.adapter;

import androidx.recyclerview.widget.DiffUtil;

import com.privat.contacts.presentation.users.model.UserItemUi;

import java.util.List;

public class UsersDiffCallback extends DiffUtil.Callback {
    private final List<UserItemUi> oldUsers;
    private final List<UserItemUi> newUsers;

    public UsersDiffCallback(List<UserItemUi> oldUsers, List<UserItemUi> newUsers) {
        this.oldUsers = oldUsers;
        this.newUsers = newUsers;
    }

    @Override
    public int getOldListSize() {
        return oldUsers.size();
    }

    @Override
    public int getNewListSize() {
        return newUsers.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return oldUsers.get(oldItemPosition).id() == newUsers.get(
                newItemPosition).id();
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        final UserItemUi oldUser = oldUsers.get(oldItemPosition);
        final UserItemUi newUser = newUsers.get(newItemPosition);
        return oldUser.favorite() == newUser.favorite();
    }

    @Override
    public Object getChangePayload(int oldItemPosition, int newItemPosition) {
        return super.getChangePayload(oldItemPosition, newItemPosition);
    }
}