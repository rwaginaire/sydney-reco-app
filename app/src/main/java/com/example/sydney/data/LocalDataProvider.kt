package com.example.sydney.data

import com.example.sydney.R
import com.example.sydney.model.Category

object LocalDataProvider {
    val appCategories: List<Category> = listOf(
        Category(
            id = 1,
            nameResourceId = R.string.category_1,
            imageResourceId = R.drawable.coffee_shop
        ),
        Category(
            id = 2,
            nameResourceId = R.string.category_2,
            imageResourceId = R.drawable.restaurant
        ),
        Category(
            id = 3,
            nameResourceId = R.string.category_3,
            imageResourceId = R.drawable.kid_friendly_place
        ),
        Category(
            id = 4,
            nameResourceId = R.string.category_4,
            imageResourceId = R.drawable.park
        ),
        Category(
            id = 5,
            nameResourceId = R.string.category_5,
            imageResourceId = R.drawable.shopping_center
        ),
    )
}