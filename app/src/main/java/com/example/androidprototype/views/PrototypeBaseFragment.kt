package com.example.androidprototype.views

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.example.androidprototype.R

abstract class PrototypeBaseFragment<DB: ViewDataBinding>: Fragment() {

    private lateinit var binding: DB

    abstract fun getLayout(): Int
    abstract fun setUp(binding: DB)
    abstract fun setListeners(binding: DB)
    abstract fun setObservers(binding: DB)


    override fun onStart() {
        super.onStart()
        setObservers(binding)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return try {
            binding = DataBindingUtil.inflate(LayoutInflater.from(context), getLayout(), null, false)
            binding.root
        } catch (e: Exception) {
            inflater.inflate(getLayout(), container, false)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUp(binding)
        setListeners(binding)
    }
}