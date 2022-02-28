package com.vk.dachecker.mathforkids.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.vk.dachecker.mathforkids.R
import com.vk.dachecker.mathforkids.databinding.FragmentGameBinding
import com.vk.dachecker.mathforkids.domain.entity.GameResult
import com.vk.dachecker.mathforkids.domain.entity.GameSettings
import com.vk.dachecker.mathforkids.domain.entity.Level

class GameFragment : Fragment() {

    private lateinit var level: Level
    private var _binding : FragmentGameBinding? = null
    private val binding: FragmentGameBinding
    get() = _binding ?: throw RuntimeException("FragmentGameBinding == null")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        parseArgs()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGameBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvSum.setOnClickListener {
            launchGameFinishedFragment(GameResult(
                true,
                12,
                12,
                GameSettings(
                    1,
                    23,
                    3,
                    4)
            ))
        }
    }

    private fun launchGameFinishedFragment(gameResult: GameResult){
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.mainContainer, GameFinishedFragment.newInstance(gameResult))
            .addToBackStack(null)
            .commit()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun parseArgs(){
        requireArguments().getParcelable<Level>(LEVEL_KEY)?.let {
            level = it
        }
    }

    companion object {
        const val NAME = "GameFragment"
        private const val LEVEL_KEY = "level"

        @JvmStatic
        fun newInstance(level:Level) : GameFragment{
            return GameFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(LEVEL_KEY, level)
                }
            }
        }
    }
}