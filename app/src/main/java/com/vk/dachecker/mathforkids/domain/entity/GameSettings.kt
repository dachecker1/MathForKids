package com.vk.dachecker.mathforkids.domain.entity

data class GameSettings (
    val maxSumValue : Int,
    val minCountOfRightAnswers: Int,
    val minPercentOnRightAnswers: Int,
    val gameTimeInSeconds: Int
        )