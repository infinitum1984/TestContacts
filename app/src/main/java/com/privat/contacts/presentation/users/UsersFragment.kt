package com.privat.contacts.presentation.users

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
import com.privat.contacts.databinding.FragmentUsersBinding
import com.privat.contacts.presentation.host.BottomNavigationHostFragmentDirections
import com.privat.contacts.presentation.users.model.UserItemUi
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class UsersFragment : DaggerFragment(), UsersView {
    @Inject
    lateinit var usersPresenter: UsersPresenter
    private var _binding: FragmentUsersBinding? = null
    private val binding get() = _binding!!
    private val usersAdapter = UsersAdapter { onClickId: Int -> usersPresenter.openUser(onClickId) }
    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentUsersBinding.inflate(inflater, container, false)
        val root: View = binding.root
        binding.rvUsers.layoutManager = LinearLayoutManager(requireContext())
        binding.rvUsers.adapter = usersAdapter
        (requireActivity() as AppCompatActivity).supportActionBar!!.setTitle(R.string.all_users)
        val itemDecorator = DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL)
        itemDecorator.setDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.divider)!!)
        binding.rvUsers.addItemDecoration(itemDecorator)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.fabFetchNewUser.setOnClickListener { listener: View? -> usersPresenter.fetchNewUser() }
        usersPresenter.clearTempData()
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        usersPresenter.onAttach(this)
    }

    override fun onDetach() {
        super.onDetach()
        usersPresenter.onDetach()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun showUsers(users: List<UserItemUi>) {
        usersAdapter.updateData(users)
        usersAdapter.notifyDataSetChanged()
    }

    override fun navigateToUser(userId: Int) {
        findNavController(requireActivity(), R.id.nav_host_fragment_activity_main)
                .navigate(
                        BottomNavigationHostFragmentDirections
                                .actionBottomNavigationHostFragmentToDetailsFragment(userId))
    }
}