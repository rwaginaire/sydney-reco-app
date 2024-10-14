package com.example.sydney.ui.screens

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.sydney.data.LocalCategoriesDataProvider
import com.example.sydney.data.LocalPlacesDataProvider
import com.example.sydney.model.Category
import com.example.sydney.model.Place
import com.example.sydney.model.toCategory
import com.example.sydney.ui.SydneyAppBar
import com.example.sydney.ui.theme.SydneyTheme

@Composable
private fun SelectPlaceScreen(
    category: Category,
    places: List<Place>,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            SydneyAppBar(
                title = stringResource(category.nameResourceId),
                canNavigateBack = true,
                navigateUp = navigateUp
            )
        },
        modifier = modifier
    ) { innerPadding ->
        SelectionScreen(
            categories = places.map { it.toCategory() },
            contentPadding = innerPadding
        )
    }
}



@Preview(showBackground = true)
@Composable
fun PlacesListItemPreview() {
    SydneyTheme(
        darkTheme = false
    ) {
        SelectPlaceScreen(
            category = LocalCategoriesDataProvider.appCategories[0],
            places = LocalPlacesDataProvider.places.filter {
                it.categoryId == 1
            },
            navigateUp = {}
        )
    }
}