package com.example.sydney.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Place(
    val id: Int,
    @StringRes val nameResourceId: Int,
    @StringRes val descResourceId: Int,
    @DrawableRes val iconResourceId: Int,
    @DrawableRes val imageResourceId: Int,
    val categoryId: Int
)

fun Place.toCategory(): Category = Category(
    id = id,
    nameResourceId = nameResourceId,
    imageResourceId = iconResourceId
)
