package com.example.sydney.model

import com.example.sydney.data.LocalCategoriesDataProvider
import com.example.sydney.data.LocalPlacesDataProvider

data class SydneyUiState(
    val categories: List<Category> = emptyList(),
    val selectedCategory: Category = LocalCategoriesDataProvider.appCategories[0],
    val selectedPlace: Place = LocalPlacesDataProvider.places[0],
    val placesToChoose: List<Place> = emptyList()
)
