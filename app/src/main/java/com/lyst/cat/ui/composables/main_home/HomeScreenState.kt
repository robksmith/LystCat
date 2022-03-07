package com.lyst.cat.ui.composables.main_home

import com.lyst.cat.data.thecatapi.dto.Breed

data class HomeScreenState(
    val isLoading: Boolean = false,
    val cats: List<Breed>? = null,
    val error: String = ""
)