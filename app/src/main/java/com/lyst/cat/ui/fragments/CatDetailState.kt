package com.lyst.cat.ui.fragments

import com.lyst.cat.data.thecatapi.dto.Breed

data class CatDetailState(
    val status: Int = 0,
    val cat: Breed? = null,
    val urls: List<String> = arrayListOf(),
    val error: String = ""
)