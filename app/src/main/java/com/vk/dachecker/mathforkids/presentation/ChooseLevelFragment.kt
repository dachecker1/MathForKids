package com.vk.dachecker.mathforkids.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.vk.dachecker.mathforkids.R
import com.vk.dachecker.mathforkids.databinding.FragmentChooseLevelBinding
import com.vk.dachecker.mathforkids.domain.entity.Level

class ChooseLevelFragment : Fragment() {
    private var _binding: FragmentChooseLevelBinding? = null
    private val binding: FragmentChooseLevelBinding
        get() = _binding ?: throw RuntimeException("FragmentChooseLevelBinding == null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentChooseLevelBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            btnTest.setOnClickListener {
                launchGameFragment(Level.TEST)
            }
            btnEasy.setOnClickListener {
                launchGameFragment(Level.EASY)
            }
            btnNormal.setOnClickListener {
                launchGameFragment(Level.NORMAL)
            }
            btnHard.setOnClickListener {
                launchGameFragment(Level.HARD)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun launchGameFragment(level: Level) {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.mainContainer, GameFragment.newInstance(level))
            .addToBackStack(GameFragment.NAME)
            .commit()
    }

    companion object {
        const val NAME = "ChooseLevelFragment"

        @JvmStatic
        fun newInstance() = ChooseLevelFragment()
    }
}