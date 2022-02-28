package com.vk.dachecker.mathforkids.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.vk.dachecker.mathforkids.R
import com.vk.dachecker.mathforkids.databinding.FragmentChooseLevelBinding

class ChooseLevelFragment : Fragment() {
    private var _binding : FragmentChooseLevelBinding? = null
    private val binding : FragmentChooseLevelBinding
    get() = _binding ?: throw RuntimeException("FragmentChooseLevelBinding == null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentChooseLevelBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {

        @JvmStatic
        fun newInstance() = ChooseLevelFragment()
    }
}