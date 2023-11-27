package com.privat.contacts.ui.users;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.privat.contacts.databinding.FragmentDashboardBinding;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;

public class UsersFragment extends DaggerFragment implements UsersView {
    private FragmentDashboardBinding binding;
    @Inject
    public UsersPresenter usersPresenter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        usersPresenter.fetchNewUser();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}