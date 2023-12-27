package com.privat.contacts.presentation.details

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.privat.contacts.R
import com.privat.contacts.databinding.FragmentDetailsBinding
import com.privat.contacts.presentation.details.model.UserDetailsParamUi
import com.privat.contacts.presentation.details.model.UserDetailsUi
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class DetailsFragment : DaggerFragment(), DetailsView {
    var binding: FragmentDetailsBinding? = null
    private val userParamsAdapter = UserParamsAdapter()

    @Inject
    lateinit var detailsPresenter: DetailsPresenter
    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentDetailsBinding.inflate(inflater, container, false)
        binding!!.rvParams.layoutManager = LinearLayoutManager(requireContext())
        binding!!.rvParams.adapter = userParamsAdapter
        binding!!.fbFavorite.setOnClickListener { listener: View? -> detailsPresenter!!.changeFavorite() }
        val itemDecorator = DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL)
        itemDecorator.setDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.divider)!!)
        binding!!.rvParams.addItemDecoration(itemDecorator)
        return binding!!.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        detailsPresenter!!.onAttach(this)
    }

    override fun onDetach() {
        super.onDetach()
        detailsPresenter!!.onDetach()
    }

    override fun showUser(userDetailsUi: UserDetailsUi) {
        userDetailsUi.loadAvatar(binding!!.ivAvatar)
        userDetailsUi.showFavorite(binding!!.fbFavorite)
        userDetailsUi.showName(binding!!.tvName)
        userDetailsUi.showPhone(binding!!.tvPhone)
    }

    override fun showUserParams(userDetailsParamUiList: List<UserDetailsParamUi>) {
        userParamsAdapter.updateData(userDetailsParamUiList)
        userParamsAdapter.notifyDataSetChanged()
    }

    override fun userId(): Int {
        return DetailsFragmentArgs.fromBundle(requireArguments()).userId
    }
}
