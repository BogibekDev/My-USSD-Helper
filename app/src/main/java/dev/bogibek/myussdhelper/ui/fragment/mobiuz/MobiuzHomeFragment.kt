package dev.bogibek.myussdhelper.ui.fragment.mobiuz

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import dev.bogibek.myussdhelper.R
import dev.bogibek.myussdhelper.databinding.FragmentMobiuzHomeBinding
import dev.bogibek.myussdhelper.manager.SharePrefManager
import dev.bogibek.myussdhelper.utils.viewBinding


class MobiuzHomeFragment : Fragment(R.layout.fragment_mobiuz_home) {
    private val binding by viewBinding { FragmentMobiuzHomeBinding.bind(it) }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {
        binding.apply {
            llUzmobile.setOnClickListener {
                SharePrefManager(requireContext()).saveInt("destination", 0)
            }
            llMobiuz.setOnClickListener {
                SharePrefManager(requireContext()).saveInt("destination", 1)
            }
            llUcell.setOnClickListener {
                SharePrefManager(requireContext()).saveInt("destination", 2)
            }
            llBeeline.setOnClickListener {
                SharePrefManager(requireContext()).saveInt("destination", 3)
            }
        }
    }

}