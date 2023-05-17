package com.example.androidprototype.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.androidprototype.R
import com.example.androidprototype.viewholders.ViewHolderData

class PersistedDataAdapter(private var list: List<String>): RecyclerView.Adapter<ViewHolderData>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolderData(
        DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_data, null, false)
    )

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: ViewHolderData, position: Int) {
        holder.bind(list[position])
    }

    fun updateData(newList: List<String>) {
        list = newList
        notifyDataSetChanged()
    }
}