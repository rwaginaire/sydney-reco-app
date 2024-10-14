package com.example.sydney.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Place(
    override val id: Int,
    @StringRes override val nameResourceId: Int,
    @StringRes val descResourceId: Int,
    @DrawableRes override val imageResourceId: Int,
    @DrawableRes val largeImageResourceId: Int,
    val categoryId: Int
) : Option()

//fun Place.toCategory(): Category = Category(
//    id = id,
//    nameResourceId = nameResourceId,
//    imageResourceId = imageResourceId
//)
