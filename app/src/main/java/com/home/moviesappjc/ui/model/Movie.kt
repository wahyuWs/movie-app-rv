package com.home.moviesappjc.ui.model

import androidx.compose.ui.unit.Dp

data class Movie(
    val image: Int,
    val title: String,
    var year: String = "",
    var rate: Double = 0.0,
    var width: Dp? = null,
    var height: Dp? = null
)
