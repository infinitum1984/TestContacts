package com.privat.contacts.presentation.favorite;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.privat.contacts.R;
import com.privat.contacts.databinding.FragmentFavoriteBinding;
import com.privat.contacts.presentation.base.BaseMvpView;
import com.privat.contacts.presentation.host.BottomNavigationHostFragmentDirections;
import com.privat.contacts.presentation.users.adapter.UsersAdapter;
import com.privat.contacts.presentation.users.model.UserItemUi;

import java.util.List;

import javax.inject.Inject;

public class FavoriteFragment extends BaseMvpView<FavoritePresenter> implements FavoriteView {
    @Inject
    FavoritePresenter favoritePresenter;
    private final UsersAdapter usersAdapter = new UsersAdapter(onClickId -> {
        Navigation.findNavController(requireActivity(), R.id.nav_host_fragment_activity_main)
                .navigate(
                        BottomNavigationHostFragmentDirections
                                .actionBottomNavigationHostFragmentToDetailsFragment(onClickId));
    }, favoriteClickId -> {
        favoritePresenter.changeFavorite(favoriteClickId);
    });
    private FragmentFavoriteBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentFavoriteBinding.inflate(inflater, container, false);
        binding.rvUsers.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.rvUsers.setAdapter(usersAdapter);
        ((AppCompatActivity) requireActivity()).getSupportActionBar().setTitle(R.string.favorite);
        DividerItemDecoration itemDecorator = new DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL);
        itemDecorator.setDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.divider));
        binding.rvUsers.addItemDecoration(itemDecorator);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        favoritePresenter.clearTempData();
        favoritePresenter.startObserve();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
        favoritePresenter.stopObserve();
    }

    @Override
    protected FavoritePresenter presenter() {
        return favoritePresenter;
    }

    @Override
    public void showFavoriteList(List<UserItemUi> userItemUis) {
        if (binding != null)
            usersAdapter.updateData(userItemUis);
    }
}