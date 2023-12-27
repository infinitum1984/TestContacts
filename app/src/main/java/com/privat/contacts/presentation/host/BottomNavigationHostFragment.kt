package com.privat.contacts.presentation.host

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.privat.contacts.R
import com.privat.contacts.databinding.FragmentHostBinding

class BottomNavigationHostFragment : Fragment() {
    private var binding: FragmentHostBinding? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentHostBinding.inflate(inflater, container, false)
        val hostFragment = childFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment?
        val navController = hostFragment!!.navController
        setupWithNavController(binding!!.navView, navController)
        return binding!!.root
    }
}