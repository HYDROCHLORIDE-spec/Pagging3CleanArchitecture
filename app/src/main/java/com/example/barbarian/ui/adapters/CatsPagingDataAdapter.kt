package com.example.barbarian.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import com.example.barbarian.domain.models.CatModel
import com.example.barbarian.core.utils.NetworkDataDiffUtils
import com.example.barbarian.databinding.ItemCatBinding
import com.example.barbarian.ui.viewholders.CatViewHolder

class CatsPagingDataAdapter : PagingDataAdapter<CatModel, CatViewHolder>(NetworkDataDiffUtils()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemCatBinding.inflate(inflater, parent, false)
        return CatViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CatViewHolder, position: Int) {
        getItem(position)?.let {
            holder bind it
        }
    }
}