package com.vk.dachecker.mathforkids.presentation

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.vk.dachecker.mathforkids.R
import com.vk.dachecker.mathforkids.domain.entity.GameResult

@BindingAdapter("requireAnswers")
fun bindingRequireAnswers(textView: TextView, count: Int) {
    textView.text = String.format(
        textView.context.getString(R.string.tv_answers_result),
        count
    )
}

@BindingAdapter("requireCountOfRightAnswers")
fun bindingRequireCountOfRightAnswers(textView: TextView, count: Int) {
    textView.text = String.format(
        textView.context.getString(R.string.tv_count_result),
        count
    )
}

@BindingAdapter("requirePercentOnRightAnswers")
fun bindingRequirePercentOnRightAnswers(textView: TextView, count: Int) {
    textView.text = String.format(
        textView.context.getString(R.string.tv_percent_result),
        count
    )
}

@BindingAdapter("isWinner")
fun bindWinnerPicture(imageView: ImageView, boolean: Boolean){
    if(boolean) {
        imageView.setImageResource(R.drawable.ic_win)
    } else {
        imageView.setImageResource(R.drawable.ic_lose)
    }
}

@BindingAdapter("scorePercentage")
fun bindScorePercentage(textView: TextView, gameResult: GameResult){
    textView.text = String.format(
        textView.context.getString(R.string.tv_your_percent_result),
        getPercentOfRightAnswers(gameResult)

    )
}

private fun getPercentOfRightAnswers(gameResult: GameResult) = with(gameResult){
    if(countOfQuestion == 0){
        0
    } else {
        ((countOfRightAnswers / countOfQuestion.toDouble()) * 100).toInt()
    }
}