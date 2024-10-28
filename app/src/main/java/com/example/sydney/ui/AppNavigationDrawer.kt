package com.example.sydney.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.PermanentDrawerSheet
import androidx.compose.material3.PermanentNavigationDrawer
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import com.example.sydney.R
import com.example.sydney.model.Category

@Composable
fun AppNavigationDrawer(
    selectedCategory: Category,
    onCategoryClick: (Category) -> Unit,
    categories: List<Category>,
    content: @Composable () -> Unit
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
        content()
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