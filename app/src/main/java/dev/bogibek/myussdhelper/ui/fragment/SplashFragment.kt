package dev.bogibek.myussdhelper.ui.fragment

import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import dev.bogibek.myussdhelper.R
import dev.bogibek.myussdhelper.manager.SharePrefManager


class SplashFragment : Fragment(R.layout.fragment_splash) {
    private var destination: Int? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        destination = SharePrefManager(requireContext()).getInt("destination")
        initViews()
    }

    private fun initViews() {

        Handler().postDelayed(Runnable {
            goNextDestination()
        }, 2000)

    }

    private fun goNextDestination() {
        when (destination) {
            0 -> {
                findNavController().navigate(R.id.action_splashFragment_to_uzmobileHomeFragment)
            }
            1 -> {
                findNavController().navigate(R.id.action_splashFragment_to_mobiuzHomeFragment)
            }
            2 -> {
                findNavController().navigate(R.id.action_splashFragment_to_ucellHomeFragment)
            }
            3 -> {
                findNavController().navigate(R.id.action_splashFragment_to_beelineHomeFragment)
            }
        }
    }

}