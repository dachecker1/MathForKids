package com.vk.dachecker.mathforkids.domain.usecase

import com.vk.dachecker.mathforkids.domain.entity.Question
import com.vk.dachecker.mathforkids.domain.repository.GameRepository

class GenerateQuestionUseCase(
    private val repository: GameRepository
) {

    operator fun invoke(maxSumValue: Int) : Question {
        return repository.generateQuestion(maxSumValue = maxSumValue, COUNT_OF_OPTIONS)
    }

    private companion object {
        private const val COUNT_OF_OPTIONS = 6
    }
}