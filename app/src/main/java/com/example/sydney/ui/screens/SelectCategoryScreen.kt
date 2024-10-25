package com.example.sydney.ui.screens

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.sydney.R
import com.example.sydney.model.Category
import com.example.sydney.ui.SelectionScreen
import com.example.sydney.ui.SydneyAppBar

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
            options = categories,
            onOptionClick = onCategoryClick,
            contentPadding = innerPadding
        )
    }
}
