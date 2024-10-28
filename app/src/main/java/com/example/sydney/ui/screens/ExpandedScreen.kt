package com.example.sydney.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.example.sydney.R
import com.example.sydney.model.Category
import com.example.sydney.model.Place
import com.example.sydney.model.SydneyUiState
import com.example.sydney.ui.AppNavigationDrawer
import com.example.sydney.ui.OptionsListItem
import com.example.sydney.ui.theme.SydneyTheme

@Composable
fun ExpandedScreen(
    uiState: SydneyUiState,
    onCategoryClick: (Category) -> Unit,
    onPlaceClick: (Place) -> Unit,
    modifier: Modifier = Modifier
) {
    ExpandedScreen(
        categories = uiState.categories,
        selectedCategory = uiState.currentCategory,
        onCategoryClick = onCategoryClick,
        recommendedPlaces = uiState.placesToChoose,
        selectedPlace = uiState.currentPlace,
        onPlaceClick = onPlaceClick,
        modifier = modifier
    )
}

@Composable
fun ExpandedScreen(
    categories: List<Category>,
    selectedCategory: Category,
    onCategoryClick: (Category) -> Unit,
    recommendedPlaces: List<Place>,
    selectedPlace: Place,
    onPlaceClick: (Place) -> Unit,
    modifier: Modifier = Modifier
) {
    AppNavigationDrawer(
        selectedCategory = selectedCategory,
        onCategoryClick = onCategoryClick,
        categories = categories
    ) {
        Row(
            modifier = modifier
                .statusBarsPadding()
        ) {
            RecommendedPlacesComponent(
                places = recommendedPlaces,
                onPlaceClick = onPlaceClick,
                selectedPlace = selectedPlace,
                modifier = Modifier.weight(2f)
            )
            RecommendedPlaceBody(
                selectedPlace,
                modifier = Modifier.weight(3f)
            )
        }
    }
}

@Composable
fun RecommendedPlacesComponent(
    places: List<Place>,
    onPlaceClick: (Place) -> Unit,
    selectedPlace: Place,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_medium)),
        modifier = modifier.padding(dimensionResource(R.dimen.padding_medium)),
    ) {
        items(places, key = { place -> place.id }) { place ->
            OptionsListItem(
                option = place,
                onItemClick = onPlaceClick,
                selected = place.id == selectedPlace.id
            )
        }
    }
}

@Preview(showBackground = true, device = Devices.TABLET)
@Composable
fun ExpandedScreenPreview() {
    SydneyTheme {
        ExpandedScreen(
            uiState = SydneyUiState(),
            {}, {}
        )
    }
}