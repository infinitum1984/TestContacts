package com.privat.contacts.presentation.favorite

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.navigation.Navigation.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.privat.contacts.R
import com.privat.contacts.databinding.FragmentFavoriteBinding
import com.privat.contacts.presentation.host.BottomNavigationHostFragmentDirections
import com.privat.contacts.presentation.users.UsersAdapter
import com.privat.contacts.presentation.users.model.UserItemUi
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class FavoriteFragment : DaggerFragment(), FavoriteView {
    @Inject
    lateinit var favoritePresenter: FavoritePresenter
    private val usersAdapter = UsersAdapter({ onClickId: Int? ->
        findNavController(requireActivity(), R.id.nav_host_fragment_activity_main)
                .navigate(
                        BottomNavigationHostFragmentDirections
                                .actionBottomNavigationHostFragmentToDetailsFragment(onClickId!!))
    }) { favoriteClickId: Int -> favoritePresenter!!.changeFavorite(favoriteClickId) }
    private var binding: FragmentFavoriteBinding? = null
    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        binding!!.rvUsers.layoutManager = LinearLayoutManager(requireContext())
        binding!!.rvUsers.adapter = usersAdapter
        (requireActivity() as AppCompatActivity).supportActionBar!!.setTitle(R.string.favorite)
        val itemDecorator = DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL)
        itemDecorator.setDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.divider)!!)
        binding!!.rvUsers.addItemDecoration(itemDecorator)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        favoritePresenter!!.clearTempData()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        favoritePresenter!!.onAttach(this)
    }

    override fun onDetach() {
        super.onDetach()
        favoritePresenter!!.onDetach()
    }

    override fun showFavoriteList(userItemUis: List<UserItemUi>) {
        usersAdapter.updateData(userItemUis)
        usersAdapter.notifyDataSetChanged()
    }
}