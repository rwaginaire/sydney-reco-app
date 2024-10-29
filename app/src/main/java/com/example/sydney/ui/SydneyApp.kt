package com.example.sydney.ui

import androidx.compose.material3.Surface
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.sydney.ui.screens.ExpandedScreen
import com.example.sydney.ui.screens.MediumScreen
import com.example.sydney.ui.screens.RecommendedPlaceScreen
import com.example.sydney.ui.screens.SelectCategoryScreen
import com.example.sydney.ui.screens.SelectPlaceScreen
import com.example.sydney.ui.theme.SydneyTheme

/**
 * enum values that represent the screens in the app
 */
enum class SydneyScreen() {
    SelectCategory,
    SelectPlace,
    PlaceInfo
}

@Composable
fun SydneyApp(
    windowSize: WindowWidthSizeClass,
    navController: NavHostController = rememberNavController()
) {
    val viewModel: SydneyViewModel = viewModel()
    val uiState by viewModel.uiState.collectAsState()

    when (windowSize) {
        WindowWidthSizeClass.Compact -> {
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
                        category = uiState.currentCategory,
                        navigateUp = { navController.navigateUp() },
                        onPlaceClick = { place ->
                            viewModel.updateSelectedPlace(place)
                            navController.navigate(SydneyScreen.PlaceInfo.name)
                        }
                    )
                }

                composable(route = SydneyScreen.PlaceInfo.name) {
                    RecommendedPlaceScreen(
                        place = uiState.currentPlace,
                        navigateUp = { navController.navigateUp() }
                    )
                }
            }
        }
        WindowWidthSizeClass.Medium -> {
            MediumScreen(
                categories = uiState.categories,
                selectedCategory = uiState.currentCategory,
                onCategoryClick = {
                    viewModel.updateSelectedCategory(it)
                },
                recommendedPlaces = uiState.placesToChoose,
                selectedPlace = uiState.currentPlace,
                onPlaceClick = { place ->
                    viewModel.updateSelectedPlace(place)
                    navController.navigate(SydneyScreen.PlaceInfo.name)
                },
                navController = navController
            )
        }
        WindowWidthSizeClass.Expanded -> {
            ExpandedScreen(
                categories = uiState.categories,
                selectedCategory = uiState.currentCategory,
                onCategoryClick = {
                    viewModel.updateSelectedCategory(it)
                },
                recommendedPlaces = uiState.placesToChoose,
                selectedPlace = uiState.currentPlace,
                onPlaceClick = {
                    viewModel.updateSelectedPlace(it)
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SydneyAppSmartphonePreview() {
    SydneyTheme {
        Surface {
            SydneyApp(
                windowSize = WindowWidthSizeClass.Compact
            )
        }
    }
}

@Preview(showBackground = true, device = Devices.TABLET)
@Composable
fun SydneyAppTabletPreview() {
    SydneyTheme {
        Surface {
            SydneyApp(
                windowSize = WindowWidthSizeClass.Expanded
            )
        }
    }
}