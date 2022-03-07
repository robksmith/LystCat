package com.lyst.cat.ui.composables.main_mycat

import android.app.Application
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.lyst.cat.domain.use_case.cats.GetAllCatBreedsUseCase
import com.lyst.cat.data.thecatapi.dto.Breed
import com.lyst.cat.ui.BaseViewModel
import com.lyst.cat.ui.result_models.UIResultModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject


@HiltViewModel
open class MyCatScreenViewModel @Inject constructor(app: Application,
                                                    savedStateHandle: SavedStateHandle
) : BaseViewModel(app)
{
    // nothing here - this is the third cat tab
}