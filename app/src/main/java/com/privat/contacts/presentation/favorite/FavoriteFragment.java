package com.privat.contacts.presentation.favorite;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.privat.contacts.databinding.FragmentFavoriteBinding;
import com.privat.contacts.presentation.users.UsersAdapter;
import com.privat.contacts.presentation.users.model.UserItemUi;

import java.util.List;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;

public class FavoriteFragment extends DaggerFragment implements FavoriteView {

    @Inject
    FavoritePresenter favoritePresenter;
    private final UsersAdapter usersAdapter = new UsersAdapter(favoriteClickId -> {
        favoritePresenter.changeFavorite(favoriteClickId);
    });
    private FragmentFavoriteBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentFavoriteBinding.inflate(inflater, container, false);
        binding.rvUsers.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.rvUsers.setAdapter(usersAdapter);
        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        favoritePresenter.onAttach(this);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        favoritePresenter.onDetach();
    }

    @Override
    public void showFavoriteList(List<UserItemUi> userItemUis) {
        usersAdapter.updateData(userItemUis);
        usersAdapter.notifyDataSetChanged();
    }
}