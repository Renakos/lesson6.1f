package com.example.lesson61f.data.model

import androidx.annotation.DrawableRes

data class ExampleModel(
    val text: String,
    @DrawableRes
    val image: Int
)