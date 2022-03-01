package com.vk.dachecker.mathforkids.presentation

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.vk.dachecker.mathforkids.domain.entity.Level

class GameViewModelFactory(
    private val application: Application,
    private val level: Level
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(GameViewModel::class.java)) {
            return GameViewModel(application,level) as T
        } else {
            throw RuntimeException("This Factory is only for GameViewModel, model class $modelClass")
        }
    }
}