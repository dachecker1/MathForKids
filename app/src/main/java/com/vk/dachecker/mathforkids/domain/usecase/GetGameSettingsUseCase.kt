package com.vk.dachecker.mathforkids.domain.usecase

import com.vk.dachecker.mathforkids.domain.entity.GameSettings
import com.vk.dachecker.mathforkids.domain.entity.Level
import com.vk.dachecker.mathforkids.domain.repository.GameRepository

class GetGameSettingsUseCase(
    private val repository: GameRepository
) {

    operator fun invoke(level: Level) : GameSettings {
        return repository.getGameSettings(level)
    }
}