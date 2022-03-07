package com.lyst.cat.ui.fragments

import android.app.Application
import androidx.lifecycle.*
import com.lyst.cat.data.thecatapi.dto.Breed
import com.lyst.cat.data.thecatapi.dto.BreedById
import com.lyst.cat.domain.use_case.cats.GetCatByIdUseCase
import com.lyst.cat.ui.BaseViewModel
import com.lyst.cat.ui.result_models.UIResultModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CatDetailViewModel @Inject constructor(app: Application,
                                             private val getCatDetailUseCase: GetCatByIdUseCase,
                                             savedStateHandle: SavedStateHandle): BaseViewModel(app)
{
    private val _state = MutableLiveData<CatDetailState>().apply {
        value = CatDetailState()
    }
    val state: LiveData<CatDetailState> = _state

    fun getCatDetail(id:String)
    {
        getCatDetailUseCase(id).onEach { result: UIResultModel<List<BreedById>> ->

            when (result.status) {
                UIResultModel.Status.REQUESTING -> {
                    _state.value = CatDetailState(status = 0)
                }
                UIResultModel.Status.SUCCESS -> {
                    // NOTE - don't do this - because short of time just grabbing some cat data to send to the ui

                    // just get the first one
                    val breedById: BreedById? = result.data?.firstOrNull()

                    // just get the first cat
                    val cat: Breed? = breedById?.breeds?.firstOrNull()

                    // grab a load of urls
                    val urls = arrayListOf<String>()
                    result.data?.forEach {
                        if (it.url != null)
                            urls.add(it.url)
                    }

                    _state.value = CatDetailState(status = 1, cat = cat, urls = urls)
                }
                UIResultModel.Status.ERROR -> {
                    _state.value = CatDetailState(status = 2, error = result.message ?: "An unexpected error occured")
                }
            }
        }.launchIn(viewModelScope)
    }
}