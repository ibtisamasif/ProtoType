package com.example.androidprototype.views

import androidx.navigation.fragment.findNavController
import com.example.androidprototype.R
import com.example.androidprototype.databinding.FragmentHomeBinding

class HomeFragment : PrototypeBaseFragment<FragmentHomeBinding>() {

    override fun getLayout() = R.layout.fragment_home

    override fun setUp(binding: FragmentHomeBinding) {
    }

    override fun setListeners(binding: FragmentHomeBinding) {
        binding.bNavigateToDataFragment.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_dataFragment)
        }
    }

    override fun setObservers(binding: FragmentHomeBinding) {
    }
}