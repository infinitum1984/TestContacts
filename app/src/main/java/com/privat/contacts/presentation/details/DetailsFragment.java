package com.privat.contacts.presentation.details;

import static androidx.navigation.fragment.FragmentKt.findNavController;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.privat.contacts.databinding.FragmentDetailsBinding;
import com.privat.contacts.databinding.FragmentFavoriteBinding;

import dagger.android.support.DaggerFragment;

public class DetailsFragment extends DaggerFragment {
    FragmentDetailsBinding binding;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentDetailsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
}
