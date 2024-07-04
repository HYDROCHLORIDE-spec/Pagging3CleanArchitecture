package com.example.barbarian.ui.activities.home

import android.os.Bundle
import com.example.barbarian.R
import com.example.barbarian.core.CATS_DATA_TYPE
import com.example.barbarian.core.bases.BaseActivity
import com.example.barbarian.core.showToastOf
import com.example.barbarian.databinding.ActivityMainBinding
import com.example.barbarian.ui.fragments.catslist.CatsListFragment
import com.example.barbarian.ui.fragments.home.HomeFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {

    override fun initializeViews() {
        binding.fragmentsContainer.setOnClickListener {
            this showToastOf R.string.hehe
        }
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragments_container, HomeFragment())
            addToBackStack(null)
            commit()
        }
    }

    fun moveToListFragment(dataCode : Int) {
        val catsList = CatsListFragment()
        val bundle = Bundle()
        bundle.putInt(CATS_DATA_TYPE, dataCode)
        catsList.arguments = bundle
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragments_container, catsList)
            addToBackStack(null)
            commit()
        }
    }

}