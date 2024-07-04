package com.example.barbarian.ui.viewholders

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.barbarian.R
import com.example.barbarian.databinding.ItemCatBinding
import com.example.barbarian.domain.models.CatModel

class CatViewHolder (private val catBinding : ItemCatBinding) :
    RecyclerView.ViewHolder(catBinding.root) {
    infix fun bind(item : CatModel?){
        catBinding.imageCat.load(item?.url){
            placeholder(R.drawable.ic_placeholder)
        }
    }
}