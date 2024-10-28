package com.example.sydney.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.PermanentDrawerSheet
import androidx.compose.material3.PermanentNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sydney.R
import com.example.sydney.model.Category
import com.example.sydney.model.Option
import com.example.sydney.model.Place
import com.example.sydney.model.SydneyUiState
import com.example.sydney.ui.OptionsListItem
import com.example.sydney.ui.SelectionScreen
import com.example.sydney.ui.SydneyApp
import com.example.sydney.ui.SydneyAppBar
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
    val navigationDrawerContentDescription = stringResource(R.string.navigation_drawer)

    PermanentNavigationDrawer(
        drawerContent = {
            PermanentDrawerSheet(
                modifier = Modifier.width(dimensionResource(R.dimen.drawer_width)),
                drawerContainerColor = MaterialTheme.colorScheme.inverseOnSurface,
            ) {
                NavigationDrawerContent(
                    selectedDestination = selectedCategory,
                    onTabPressed = onCategoryClick,
                    navigationItemContentList = categories,
                    modifier = Modifier
                        .wrapContentWidth()
                        .fillMaxHeight()
                        .background(MaterialTheme.colorScheme.inverseOnSurface)
                )
            }
        },
        modifier = Modifier.testTag(navigationDrawerContentDescription)
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

@Composable
private fun NavigationDrawerContent(
    selectedDestination: Category,
    onTabPressed: ((Category) -> Unit),
    navigationItemContentList: List<Category>,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        NavigationDrawerHeader(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = MaterialTheme.colorScheme.primaryContainer)
                .padding(dimensionResource(R.dimen.padding_medium)),
        )
        Column(
            modifier = Modifier.padding(dimensionResource(R.dimen.drawer_padding_content))
        ) {
            for (navItem in navigationItemContentList) {
                NavigationDrawerItem(
                    selected = selectedDestination == navItem,
                    label = {
                        Text(
                            text = stringResource(navItem.nameResourceId),
                            modifier = Modifier.padding(horizontal = dimensionResource(R.dimen.padding_medium))
                        )
                    },
                    icon = {
                        Icon(
                            imageVector = ImageVector.vectorResource(navItem.iconResourceId),
                            contentDescription = stringResource(navItem.nameResourceId)
                        )
                    },
                    colors = NavigationDrawerItemDefaults.colors(
                        unselectedContainerColor = Color.Transparent
                    ),
                    onClick = { onTabPressed(navItem) }
                )
            }
        }
    }
}

@Composable
private fun NavigationDrawerHeader(
    modifier: Modifier = Modifier
) {
    Text(
        text = stringResource(R.string.app_name),
        fontWeight = FontWeight.Bold,
        modifier = modifier,
        color = MaterialTheme.colorScheme.secondary
    )
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