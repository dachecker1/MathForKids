package com.vk.dachecker.mathforkids.domain.repository

import com.vk.dachecker.mathforkids.domain.entity.GameSettings
import com.vk.dachecker.mathforkids.domain.entity.Level
import com.vk.dachecker.mathforkids.domain.entity.Question

interface GameRepository {

    fun generateQuestion(
        maxSumValue: Int,
        countOfOptions: Int
    ): Question

    fun getGameSettings(level: Level) : GameSettings
}