package com.privat.contacts.presentation.users;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.privat.contacts.databinding.FragmentUsersBinding;
import com.privat.contacts.presentation.users.model.UserItemUi;

import java.util.List;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;

public class UsersFragment extends DaggerFragment implements UsersView {
    @Inject
    public UsersPresenter usersPresenter;
    private FragmentUsersBinding binding;
    private final UsersAdapter usersAdapter = new UsersAdapter(favoriteClickId -> {
        usersPresenter.changeFavorite(favoriteClickId);
    });

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentUsersBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        binding.rvUsers.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.rvUsers.setAdapter(usersAdapter);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.fabFetchNewUser.setOnClickListener(listener -> {
            usersPresenter.fetchNewUser();
        });
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        usersPresenter.onAttach(this);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        usersPresenter.onDetach();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void showUsers(List<UserItemUi> users) {
        usersAdapter.updateData(users);
        usersAdapter.notifyDataSetChanged();
    }
}