package com.example.sydney.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.ui.graphics.vector.ImageVector

data class Category(
    override val id: Int,
    @StringRes override val nameResourceId: Int,
    @DrawableRes override val imageResourceId: Int,
    @DrawableRes val iconResourceId: Int
) : Option()
