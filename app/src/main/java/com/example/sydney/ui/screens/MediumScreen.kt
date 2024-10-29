package com.example.sydney.ui.screens

import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.sydney.model.Category
import com.example.sydney.model.Place
import com.example.sydney.model.SydneyUiState
import com.example.sydney.ui.AppNavigationDrawer
import com.example.sydney.ui.SelectionScreen
import com.example.sydney.ui.SydneyScreen
import com.example.sydney.ui.theme.SydneyTheme

@Composable
fun MediumScreen(
    categories: List<Category>,
    selectedCategory: Category,
    onCategoryClick: (Category) -> Unit,
    recommendedPlaces: List<Place>,
    selectedPlace: Place,
    onPlaceClick: (Place) -> Unit,
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = SydneyScreen.SelectPlace.name
    ) {
        composable(route = SydneyScreen.SelectPlace.name) {
            AppNavigationDrawer(
                selectedCategory = selectedCategory,
                onCategoryClick = onCategoryClick,
                categories = categories
            ) {
                SelectionScreen(
                    options = recommendedPlaces,
                    onOptionClick = onPlaceClick,
                    modifier = modifier.statusBarsPadding()
                )
            }
        }

        composable(route = SydneyScreen.PlaceInfo.name) {
            RecommendedPlaceScreen(
                place = selectedPlace,
                navigateUp = { navController.navigateUp() },
                modifier = modifier
            )
        }
    }
}


@Composable
fun MediumScreen(
    uiState: SydneyUiState,
    onCategoryClick: (Category) -> Unit,
    onPlaceClick: (Place) -> Unit,
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    MediumScreen(
        categories = uiState.categories,
        selectedCategory = uiState.currentCategory,
        onCategoryClick = onCategoryClick,
        recommendedPlaces = uiState.placesToChoose,
        selectedPlace = uiState.currentPlace,
        onPlaceClick = onPlaceClick,
        modifier = modifier,
        navController = navController
    )
}

@Preview(showBackground = true, widthDp = 700)
@Composable
fun MediumScreenPreview() {
    SydneyTheme {
        MediumScreen(
            uiState = SydneyUiState(),
            {}, {}
        )
    }
}