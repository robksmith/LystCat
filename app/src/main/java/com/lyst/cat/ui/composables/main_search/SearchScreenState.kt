package com.lyst.cat.ui.composables.main_search

import com.lyst.cat.data.thecatapi.dto.Breed

data class SearchScreenState(
    val isLoading: Boolean = false,
    val cats: List<Breed>? = null,
    val error: String = ""
)
