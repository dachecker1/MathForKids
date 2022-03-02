package com.vk.dachecker.mathforkids.domain.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GameResult(
    val winner: Boolean,
    val countOfRightAnswers: Int,
    val countOfQuestion: Int,
    val gameSettings: GameSettings
) : Parcelable {
    val countOfRightAnswersString: String
    get() = countOfRightAnswers.toString()
}