package com.example.sydney.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.sydney.ui.screens.RecommendedPlaceScreen
import com.example.sydney.ui.screens.SelectCategoryScreen
import com.example.sydney.ui.screens.SelectPlaceScreen

/**
 * enum values that represent the screens in the app
 */
enum class SydneyScreen() {
    SelectCategory,
    SelectPlace,
    PlaceInfo
}

@Composable
fun SydneyApp(navController: NavHostController = rememberNavController()) {
    val viewModel: SydneyViewModel = viewModel()
    val uiState by viewModel.uiState.collectAsState()

    NavHost(
        navController = navController,
        startDestination = SydneyScreen.SelectCategory.name
    ){
        composable(route = SydneyScreen.SelectCategory.name) {
            SelectCategoryScreen(
                categories = uiState.categories,
                onCategoryClick = { category ->
                    viewModel.updateSelectedCategory(category)
                    navController.navigate(SydneyScreen.SelectPlace.name)
                }
            )
        }

        composable(route = SydneyScreen.SelectPlace.name) {
            SelectPlaceScreen(
                places = uiState.placesToChoose,
                category = uiState.selectedCategory,
                navigateUp = { navController.navigateUp() },
                onPlaceClick = { place ->
                    viewModel.updateSelectedPlace(place)
                    navController.navigate(SydneyScreen.PlaceInfo.name)
                }
            )
        }

        composable(route = SydneyScreen.PlaceInfo.name) {
            RecommendedPlaceScreen(
                place = uiState.selectedPlace,
                navigateUp = { navController.navigateUp() }
            )
        }
    }
}