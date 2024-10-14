package com.example.sydney.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.sydney.data.LocalPlacesDataProvider
import com.example.sydney.model.Place
import com.example.sydney.model.toCategory
import com.example.sydney.ui.theme.SydneyTheme

@Composable
private fun SelectPlaceScreen(
    places: List<Place>,
    modifier: Modifier = Modifier
) {
    SelectionScreen(
        categories = places.map { it.toCategory() },
        modifier = modifier
    )
}



@Preview(showBackground = true)
@Composable
fun PlacesListItemPreview() {
    SydneyTheme {
        SelectPlaceScreen(
            LocalPlacesDataProvider.places.filter {
                it.categoryId == 1
            },
        )
    }
}