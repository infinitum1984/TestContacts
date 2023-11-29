package com.privat.contacts.presentation.host;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.privat.contacts.R;
import com.privat.contacts.databinding.FragmentHostBinding;

import dagger.android.support.DaggerFragment;

public class BottomNavigationHostFragment extends Fragment {
    private FragmentHostBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentHostBinding.inflate(inflater, container, false);
        NavHostFragment hostFragment = (NavHostFragment) getChildFragmentManager().findFragmentById(R.id.nav_host_fragment);
        NavController navController = hostFragment.getNavController();
        NavigationUI.setupWithNavController(binding.navView, navController);
        return binding.getRoot();
    }
}