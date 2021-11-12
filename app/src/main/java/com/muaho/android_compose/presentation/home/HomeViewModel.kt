package com.muaho.android_compose.presentation.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.muaho.android_compose.domain.HomeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class HomeViewModel(
    private val repository: HomeRepository,
    private val homeMapper: HomeMapper,
) : ViewModel() {
    var homeState by mutableStateOf<HomeState>(
        HomeState.Loading
    )

    init {
        viewModelScope.launch(Dispatchers.IO) {
            delay(1000)
            val home = repository.getHome()
            viewModelScope.launch(Dispatchers.Main) {
                homeState = homeMapper.mapHome(home)
            }

        }
    }

    class Factory(
        private val repository: HomeRepository,
        private val homeMapper: HomeMapper,
    ) : ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T =
            HomeViewModel(
                repository = repository,
                homeMapper = homeMapper
            ) as T
    }

}
