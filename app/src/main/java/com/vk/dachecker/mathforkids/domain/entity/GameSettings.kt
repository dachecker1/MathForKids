package com.vk.dachecker.mathforkids.domain.entity

import android.os.Parcel
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GameSettings (
    val maxSumValue : Int,
    val minCountOfRightAnswers: Int,
    val minPercentOnRightAnswers: Int,
    val gameTimeInSeconds: Int
        ) : Parcelable