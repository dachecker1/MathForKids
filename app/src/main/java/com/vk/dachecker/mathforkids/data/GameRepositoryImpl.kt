package com.vk.dachecker.mathforkids.data

import com.vk.dachecker.mathforkids.domain.entity.GameSettings
import com.vk.dachecker.mathforkids.domain.entity.Level
import com.vk.dachecker.mathforkids.domain.entity.Question
import com.vk.dachecker.mathforkids.domain.repository.GameRepository
import java.lang.Integer.max
import kotlin.random.Random

object GameRepositoryImpl : GameRepository {

    private const val MIN_SUM_VALUE = 2
    private const val MIN_ANSWER_VALUE = 1

    override fun generateQuestion(maxSumValue: Int, countOfOptions: Int): Question {
        val sum = Random.nextInt(MIN_SUM_VALUE, maxSumValue + 1)
        val visibleNumber = Random.nextInt(MIN_ANSWER_VALUE, sum)
        val options = HashSet<Int>()
        val rightAnswer = sum - visibleNumber
        options.add(rightAnswer)
        val from = max(rightAnswer - countOfOptions, MIN_ANSWER_VALUE)
        val to = max(maxSumValue, rightAnswer + countOfOptions)
        while (options.size < countOfOptions) {
            options.add(Random.nextInt(from, to))
        }
        return Question(sum, visibleNumber, options.toList())
    }

    override fun getGameSettings(level: Level): GameSettings {
        return when (level) {
            Level.TEST -> GameSettings(10, 3, 50, 10)
            Level.EASY -> GameSettings(10, 15, 70, 60)
            Level.NORMAL -> GameSettings(30, 20, 80, 50)
            Level.HARD -> GameSettings(50, 30, 90, 40)
        }
    }
}