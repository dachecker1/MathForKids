package com.vk.dachecker.mathforkids.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.vk.dachecker.mathforkids.R
import com.vk.dachecker.mathforkids.databinding.FragmentGameBinding
import com.vk.dachecker.mathforkids.domain.entity.GameResult
import com.vk.dachecker.mathforkids.domain.entity.Level

class GameFragment : Fragment() {

    private lateinit var viewModel : GameViewModel
    private lateinit var level: Level
    private var _binding : FragmentGameBinding? = null
    private val binding: FragmentGameBinding
    get() = _binding ?: throw RuntimeException("FragmentGameBinding == null")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        parseArgs()
        viewModel = ViewModelProvider(this)[GameViewModel::class.java]

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
        printNumbers()
        getAnswers()
    }

    private fun getAnswers() {
        binding.run {
            tvOption1.setOnClickListener {
                val number = tvOption1.text.toString().toInt()
                val rightAnswer = tvSum.text.toString().toInt() - tvLeftNumber.text.toString().toInt()
                if(rightAnswer == number){
                    Toast.makeText(context, "правильный ответ", Toast.LENGTH_LONG).show()
                }
                printNumbers()
            }
            tvOption2.setOnClickListener {
                val number = tvOption2.text.toString().toInt()
                val rightAnswer = tvSum.text.toString().toInt() - tvLeftNumber.text.toString().toInt()
                if(rightAnswer == number){
                    Toast.makeText(context, "правильный ответ", Toast.LENGTH_LONG).show()
                }
                printNumbers()
            }
            tvOption3.setOnClickListener {
                val number = tvOption3.text.toString().toInt()
                val rightAnswer = tvSum.text.toString().toInt() - tvLeftNumber.text.toString().toInt()
                if(rightAnswer == number){
                    Toast.makeText(context, "правильный ответ", Toast.LENGTH_LONG).show()
                }
                printNumbers()
            }
            tvOption4.setOnClickListener {
                val number = tvOption4.text.toString().toInt()
                val rightAnswer = tvSum.text.toString().toInt() - tvLeftNumber.text.toString().toInt()
                if(rightAnswer == number){
                    Toast.makeText(context, "правильный ответ", Toast.LENGTH_LONG).show()
                }
                printNumbers()
            }
            tvOption5.setOnClickListener {
                val number = tvOption1.text.toString().toInt()
                val rightAnswer = tvSum.text.toString().toInt() - tvLeftNumber.text.toString().toInt()
                if(rightAnswer == number){
                    Toast.makeText(context, "правильный ответ", Toast.LENGTH_LONG).show()
                }
                printNumbers()
            }
            tvOption6.setOnClickListener {
                val number = tvOption1.text.toString().toInt()
                val rightAnswer = tvSum.text.toString().toInt() - tvLeftNumber.text.toString().toInt()
                if(rightAnswer == number){
                    Toast.makeText(context, "правильный ответ", Toast.LENGTH_LONG).show()
                }
                printNumbers()
            }
        }
    }

    private fun printNumbers(){
        val question = viewModel.getQuestion(level)
        binding.run {
            tvSum.text = question.sum.toString()
            tvLeftNumber.text = question.visibleNumber.toString()
            tvOption1.text = question.options[0].toString()
            tvOption2.text = question.options[1].toString()
            tvOption3.text = question.options[2].toString()
            tvOption4.text = question.options[3].toString()
            tvOption5.text = question.options[4].toString()
            tvOption6.text = question.options[5].toString()
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