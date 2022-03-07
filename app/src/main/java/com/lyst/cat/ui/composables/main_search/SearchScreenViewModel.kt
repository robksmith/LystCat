package com.lyst.cat.ui.composables.main_search

import android.app.Application
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.lyst.cat.domain.use_case.cats.SearchCatBreedsUseCase
import com.lyst.cat.ui.BaseViewModel
import com.lyst.cat.ui.result_models.UIResultModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
open class SearchScreenViewModel @Inject constructor(app: Application,
                                                   private val searchUseCase: SearchCatBreedsUseCase,
                                                   savedStateHandle: SavedStateHandle
) : BaseViewModel(app)
{
    private var job: Job? = null
    private val _state = mutableStateOf(SearchScreenState())
    val state: State<SearchScreenState> = _state

    val query = mutableStateOf("")
    fun onSearchTermChanged(newSearchTerm:String)
    {
        query.value = newSearchTerm

        // Needs more work - uncomment if you want to make the search call 2 seconds after the user finishes typing. Other coroutines will get cancelled
//        job?.cancel()
//        job = viewModelScope.launch {
//            delay(2000)
//            listCats(newSearchTerm)
//        }
    }

    fun onMakeCall()
    {
        if (query.value.isNotBlank())
            listCats(query.value)
    }

    private fun listCats(newSearchTerm: String)
    {
        searchUseCase(newSearchTerm).onEach { result ->

            when (result.status) {
                UIResultModel.Status.SUCCESS -> {
                    _state.value = SearchScreenState(cats = result.data)
                }
                UIResultModel.Status.ERROR -> {
                    _state.value = SearchScreenState(
                        error = result.message ?: "An unexpected error occured"
                    )
                }
                UIResultModel.Status.REQUESTING -> {
                    _state.value = SearchScreenState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}