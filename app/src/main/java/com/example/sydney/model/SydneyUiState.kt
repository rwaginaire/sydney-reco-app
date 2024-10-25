package com.example.sydney.model

import com.example.sydney.data.LocalCategoriesDataProvider
import com.example.sydney.data.LocalPlacesDataProvider

data class SydneyUiState(
    val categories: List<Category> = LocalCategoriesDataProvider.appCategories,
    val currentCategory: Category = LocalCategoriesDataProvider.appCategories[0],
    val currentPlace: Place = LocalPlacesDataProvider.places[0],
    val placesToChoose: List<Place> = LocalPlacesDataProvider.places.filter {
        it.categoryId == 1
    }
    )
