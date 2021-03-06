package com.vk.dachecker.mathforkids.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.FragmentManager
import com.vk.dachecker.mathforkids.R
import com.vk.dachecker.mathforkids.databinding.FragmentGameFinishedBinding
import com.vk.dachecker.mathforkids.domain.entity.GameResult
import com.vk.dachecker.mathforkids.domain.entity.Level

class GameFinishedFragment : Fragment() {
    private lateinit var gameResult: GameResult
    private var _binding: FragmentGameFinishedBinding? = null
    private val binding: FragmentGameFinishedBinding
        get() = _binding ?: throw RuntimeException("FragmentGameFinishedBinding == null")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        parseArgs()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGameFinishedBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showResult()
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    retryGame()
                }
            })

        binding.btnTryAgain.setOnClickListener {
            retryGame()
        }
    }

    private fun showResult() {
        binding.tvAnswers.text = String.format(
            getString(R.string.tv_answers_result),
            gameResult.gameSettings.minCountOfRightAnswers
        )
        binding.tvCount.text =
            String.format(getString(R.string.tv_count_result),
                gameResult.countOfRightAnswers)
        binding.tvPercent.text = String.format(
            getString(R.string.tv_percent_result),
            gameResult.gameSettings.minPercentOnRightAnswers
        )
        binding.tvYourPercent.text =
            String.format(getString(R.string.tv_your_percent_result),
                getPercentOfRightsAnswers())

        if (gameResult.winner) {
            binding.imResult.setImageResource(R.drawable.ic_win)
        }
    }

    private fun getPercentOfRightsAnswers() = with(gameResult) {
        if (countOfQuestion == 0) {
            0
        } else {
            ((countOfRightAnswers / countOfQuestion.toDouble()) * 100).toInt()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun parseArgs() {
        requireArguments().getParcelable<GameResult>(KEY_GAME_RESULT)?.let {
            gameResult = it
        }
    }

    private fun retryGame() {
        requireActivity().supportFragmentManager.popBackStack(
            GameFragment.NAME,
            FragmentManager.POP_BACK_STACK_INCLUSIVE
        )
    }

    companion object {
        private const val KEY_GAME_RESULT = "result"

        @JvmStatic
        fun newInstance(gameResult: GameResult): GameFinishedFragment {
            return GameFinishedFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(KEY_GAME_RESULT, gameResult)
                }
            }
        }
    }
}