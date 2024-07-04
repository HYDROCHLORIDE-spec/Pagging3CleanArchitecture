package com.example.barbarian.core.utils

import androidx.recyclerview.widget.DiffUtil
import com.example.barbarian.domain.models.CatModel

class NetworkDataDiffUtils : DiffUtil.ItemCallback<CatModel>() {
    override fun areItemsTheSame(oldItem: CatModel, newItem: CatModel) = oldItem.id == newItem.id
    override fun areContentsTheSame(oldItem: CatModel, newItem: CatModel) = oldItem == newItem
}