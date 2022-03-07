package com.lyst.cat.ui.composables.main_home

import android.app.Application
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.lyst.cat.domain.use_case.cats.GetAllCatBreedsUseCase
import com.lyst.cat.ui.BaseViewModel
import com.lyst.cat.ui.result_models.UIResultModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
open class HomeScreenViewModel @Inject constructor(app: Application,
                                                   private val getRandomCatUseCase: GetAllCatBreedsUseCase,
                                                   savedStateHandle: SavedStateHandle
) : BaseViewModel(app)
{
    private val _state = mutableStateOf(HomeScreenState())
    val state: State<HomeScreenState> = _state

    init
    {
        listCats()
    }

    private fun listCats()
    {
        getRandomCatUseCase().onEach { result ->

            when (result.status) {
                UIResultModel.Status.SUCCESS -> {
                    _state.value = HomeScreenState(cats = result.data)
                }
                UIResultModel.Status.ERROR -> {
                    _state.value = HomeScreenState(
                        error = result.message ?: "An unexpected error occured"
                    )
                }
                UIResultModel.Status.REQUESTING -> {
                    _state.value = HomeScreenState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}