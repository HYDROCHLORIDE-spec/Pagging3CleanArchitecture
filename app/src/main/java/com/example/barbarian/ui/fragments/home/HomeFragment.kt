package com.example.barbarian.ui.fragments.home

import com.example.barbarian.core.bases.BaseFragment
import com.example.barbarian.core.utils.DataType
import com.example.barbarian.databinding.FragmentHomeBinding
import com.example.barbarian.ui.activities.home.MainActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(
    FragmentHomeBinding::inflate
) {

    override fun viewInitialized() {
        binding.apply {
            localCats.setOnClickListener {
                (requireActivity() as? MainActivity)?.moveToListFragment(DataType.Local.dataCode)
            }
            remoteCats.setOnClickListener {
                (requireActivity() as? MainActivity)?.moveToListFragment(DataType.Network.dataCode)
            }
            localAndRemoteCats.setOnClickListener {
                (requireActivity() as? MainActivity)?.moveToListFragment(DataType.Mediator.dataCode)
            }
        }
    }

}