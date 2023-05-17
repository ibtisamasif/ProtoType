package com.example.androidprototype.views

import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.example.androidprototype.R
import com.example.androidprototype.adapters.PersistedDataAdapter
import com.example.androidprototype.databinding.FragmentDataBinding
import com.example.androidprototype.viewmodels.DataViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class DataFragment : PrototypeBaseFragment<FragmentDataBinding>() {

    private lateinit var adapter: PersistedDataAdapter
    private val viewModel: DataViewModel by viewModel()

    override fun getLayout() = R.layout.fragment_data

    override fun setUp(binding: FragmentDataBinding) {
        adapter = PersistedDataAdapter(arrayListOf())
        binding.rvPersistedData.adapter = adapter
        viewModel.fetchData()

//        lifecycleScope.launch(Dispatchers.IO) {
//            // We need this delay because currently it's so fast that the observer misses it.
//            delay(100L)
//            viewModel.fetchData()
//        }
    }

    private fun populateData(list: List<String>) {
        adapter.updateData(list)
    }

    override fun setListeners(binding: FragmentDataBinding) {
        binding.tvAddData.setOnClickListener {
            viewModel.storeData(binding.etAddData.text.toString())
        }
        binding.ivBack.setOnClickListener { activity?.onBackPressed() }
        binding.tvBack.setOnClickListener { activity?.onBackPressed() }
    }

    override fun setObservers(binding: FragmentDataBinding) {
        lifecycleScope.launch(Dispatchers.Main) {
            viewModel.validateInputSharedFlow.collectLatest {
                if (it) {
                    Toast.makeText(activity, "Data Stored", Toast.LENGTH_LONG).show()
                    viewModel.fetchData()
                } else Toast.makeText(activity, "Invalid Input", Toast.LENGTH_LONG).show()
            }
        }

        lifecycleScope.launch(Dispatchers.Main) {
            viewModel.fetchDataSharedFlow.collectLatest {
                populateData(it)
            }
        }
    }
}