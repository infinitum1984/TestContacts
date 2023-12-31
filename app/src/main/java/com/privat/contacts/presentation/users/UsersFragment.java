package com.privat.contacts.presentation.users;

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
import com.privat.contacts.databinding.FragmentUsersBinding;
import com.privat.contacts.presentation.base.BaseMvpView;
import com.privat.contacts.presentation.host.BottomNavigationHostFragmentDirections;
import com.privat.contacts.presentation.users.adapter.UsersAdapter;
import com.privat.contacts.presentation.users.model.UserItemUi;

import java.util.List;

import javax.inject.Inject;

public class UsersFragment extends BaseMvpView<UsersPresenter> implements UsersView {
    @Inject
    public UsersPresenter usersPresenter;
    private FragmentUsersBinding binding;
    private final UsersAdapter usersAdapter = new UsersAdapter(onClickId -> {
        usersPresenter.openUser(onClickId);
    });
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentUsersBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        ((AppCompatActivity) requireActivity()).getSupportActionBar().setTitle(R.string.all_users);
        DividerItemDecoration itemDecorator = new DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL);
        itemDecorator.setDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.divider));
        binding.rvUsers.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.rvUsers.setAdapter(usersAdapter);
        binding.rvUsers.addItemDecoration(itemDecorator);
        return root;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.fabFetchNewUser.setOnClickListener(listener -> {
            usersPresenter.fetchNewUser();
        });
        usersPresenter.clearTempData();
        usersPresenter.startObserve();
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        usersPresenter.stopObserve();
        binding = null;
    }
    @Override
    public void showUsers(List<UserItemUi> users) {
        if (binding != null) {
            usersAdapter.updateData(users);
            binding.rvUsers.smoothScrollToPosition(users.size() - 1);
        }
    }
    @Override
    public void navigateToUser(int userId) {
        Navigation.findNavController(requireActivity(), R.id.nav_host_fragment_activity_main)
                .navigate(
                        BottomNavigationHostFragmentDirections
                                .actionBottomNavigationHostFragmentToDetailsFragment(userId));
    }
    @Override
    protected UsersPresenter presenter() {
        return usersPresenter;
    }
}