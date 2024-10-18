package com.example.sydney.ui.screens

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.sydney.R
import com.example.sydney.data.LocalCategoriesDataProvider
import com.example.sydney.model.Category
import com.example.sydney.ui.SelectionScreen
import com.example.sydney.ui.SydneyAppBar
import com.example.sydney.ui.theme.SydneyTheme

@Composable
fun SelectCategoryScreen(
    categories: List<Category>,
    onCategoryClick: (Category) -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            SydneyAppBar(
                title = stringResource(R.string.app_name),
                canNavigateBack = false
            )
        },
        modifier = modifier
    ) { innerPadding ->
        SelectionScreen(
            categories = categories,
            onCategoryClick = onCategoryClick,
            contentPadding = innerPadding
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SelectCategoryScreenPreview() {
    SydneyTheme(
        darkTheme = false
    ) {
        SelectCategoryScreen(
            categories = LocalCategoriesDataProvider.appCategories,
            onCategoryClick = {}
        )
    }
}