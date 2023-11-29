package com.privat.contacts.presentation.details;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.privat.contacts.R;
import com.privat.contacts.base.presentation.BaseMvpView;
import com.privat.contacts.databinding.FragmentDetailsBinding;
import com.privat.contacts.presentation.details.model.UserDetailsParamUi;
import com.privat.contacts.presentation.details.model.UserDetailsUi;

import java.util.List;

import javax.inject.Inject;

public class DetailsFragment extends BaseMvpView<DetailsPresenter> implements DetailsView {
    FragmentDetailsBinding binding;
    private final UserParamsAdapter userParamsAdapter = new UserParamsAdapter();
    @Inject
    DetailsPresenter detailsPresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentDetailsBinding.inflate(inflater, container, false);
        binding.rvParams.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.rvParams.setAdapter(userParamsAdapter);
        binding.fbFavorite.setOnClickListener((listener)->{
            detailsPresenter.changeFavorite();
        });
        DividerItemDecoration itemDecorator = new DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL);
        itemDecorator.setDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.divider));
        binding.rvParams.addItemDecoration(itemDecorator);
        return binding.getRoot();
    }

    @Override
    protected DetailsPresenter presenter() {
        return detailsPresenter;
    }

    @Override
    public void showUser(UserDetailsUi userDetailsUi) {
        userDetailsUi.loadAvatar(binding.ivAvatar);
        userDetailsUi.showFavorite(binding.fbFavorite);
        userDetailsUi.showName(binding.tvName);
        userDetailsUi.showPhone(binding.tvPhone);
    }

    @Override
    public void showUserParams(List<UserDetailsParamUi> userDetailsParamUiList) {
        userParamsAdapter.updateData(userDetailsParamUiList);
        userParamsAdapter.notifyDataSetChanged();
    }

    @Override
    public int userId() {
        return DetailsFragmentArgs.fromBundle(requireArguments()).getUserId();
    }

    @Override
    public void showError(Throwable throwable) {

    }
}