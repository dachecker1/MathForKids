package com.vk.dachecker.mathforkids.domain.entity

import java.io.Serializable

data class GameSettings (
    val maxSumValue : Int,
    val minCountOfRightAnswers: Int,
    val minPercentOnRightAnswers: Int,
    val gameTimeInSeconds: Int
        ) : Serializable