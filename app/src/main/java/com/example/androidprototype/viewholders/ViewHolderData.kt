package com.example.androidprototype.viewholders

import androidx.recyclerview.widget.RecyclerView
import com.example.androidprototype.databinding.ItemDataBinding

class ViewHolderData(private val binding: ItemDataBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(data: String) {
        binding.tvData.text = data
    }
}