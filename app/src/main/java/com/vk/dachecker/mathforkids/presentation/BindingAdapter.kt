package com.vk.dachecker.mathforkids.presentation

import android.content.Context
import android.content.res.ColorStateList
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat
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
fun bindWinnerPicture(imageView: ImageView, boolean: Boolean) {
    if (boolean) {
        imageView.setImageResource(R.drawable.ic_win)
    } else {
        imageView.setImageResource(R.drawable.ic_lose)
    }
}

@BindingAdapter("scorePercentage")
fun bindScorePercentage(textView: TextView, gameResult: GameResult) {
    textView.text = String.format(
        textView.context.getString(R.string.tv_your_percent_result),
        getPercentOfRightAnswers(gameResult)

    )
}

private fun getPercentOfRightAnswers(gameResult: GameResult) = with(gameResult) {
    if (countOfQuestion == 0) {
        0
    } else {
        ((countOfRightAnswers / countOfQuestion.toDouble()) * 100).toInt()
    }
}

@BindingAdapter("enoughCount")
fun bindTvProgress(textView: TextView, flag: Boolean) {
    textView.setTextColor(getColorByState(textView.context, flag))
}

@BindingAdapter("enoughPercent")
fun bindPbLine(pb: ProgressBar, flag: Boolean) {
    val color = getColorByState(pb.context, flag)
    pb.progressTintList = ColorStateList.valueOf(color)
}

private fun getColorByState(context: Context, flag: Boolean): Int {
    val colorResId = if (flag) {
        android.R.color.holo_green_dark
    } else {
        android.R.color.holo_orange_dark
    }
    return ContextCompat.getColor(context, colorResId)
}

@BindingAdapter("textSum")
fun bindTextSum(textView: TextView, int: Int){
    textView.text = int.toString()
}

@BindingAdapter("visibleNumber")
fun bindVisibleNUmber(textView: TextView, int: Int){
    textView.text = int.toString()
}
