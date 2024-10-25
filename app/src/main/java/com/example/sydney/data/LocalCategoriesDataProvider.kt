package com.example.sydney.data

import androidx.compose.material.icons.Icons
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import com.example.sydney.R
import com.example.sydney.model.Category

object LocalCategoriesDataProvider {
    val appCategories: List<Category> = listOf(
        Category(
            id = 1,
            nameResourceId = R.string.category_1,
            imageResourceId = R.drawable.coffee_shop,
            iconResourceId = R.drawable.local_cafe
        ),
        Category(
            id = 2,
            nameResourceId = R.string.category_2,
            imageResourceId = R.drawable.restaurant,
            iconResourceId = R.drawable.restaurant_icon
        ),
        Category(
            id = 3,
            nameResourceId = R.string.category_3,
            imageResourceId = R.drawable.kid_friendly_place,
            iconResourceId = R.drawable.family_restroom
        ),
        Category(
            id = 4,
            nameResourceId = R.string.category_4,
            imageResourceId = R.drawable.park,
            iconResourceId = R.drawable.park_icon
        ),
        Category(
            id = 5,
            nameResourceId = R.string.category_5,
            imageResourceId = R.drawable.shopping_center,
            iconResourceId = R.drawable.shopping_bag
        ),
    )
}