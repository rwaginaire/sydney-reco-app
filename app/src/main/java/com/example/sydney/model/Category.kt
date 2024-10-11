package com.example.sydney.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Category(
    val id: Int,
    @StringRes val nameResourceId: Int,
    @DrawableRes val imageResourceId: Int
)
