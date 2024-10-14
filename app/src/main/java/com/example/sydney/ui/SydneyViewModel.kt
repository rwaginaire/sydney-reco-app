package com.example.sydney.ui

import androidx.lifecycle.ViewModel
import com.example.sydney.data.LocalCategoriesDataProvider
import com.example.sydney.data.LocalPlacesDataProvider
import com.example.sydney.model.Category
import com.example.sydney.model.Option
import com.example.sydney.model.Place
import com.example.sydney.model.SydneyUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlin.reflect.typeOf

class SydneyViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(
        SydneyUiState(
            categories = LocalCategoriesDataProvider.appCategories
        )
    )

    val uiState: StateFlow<SydneyUiState> =_uiState

    fun updateSelectedCategory(category: Category) {
        val categoryPlaces = LocalPlacesDataProvider.places.filter { place ->
            place.categoryId == category.id
        }
        _uiState.update {
            it.copy(
                selectedCategory = category,
                placesToChoose = categoryPlaces
            )
        }
    }

    fun updateSelectedPlace(place: Place) {
        _uiState.update {
            it.copy(
                selectedPlace = place
            )
        }
    }
}