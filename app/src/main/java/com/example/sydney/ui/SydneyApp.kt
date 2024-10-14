package com.example.sydney.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.sydney.R
import com.example.sydney.ui.screens.SelectCategoryScreen
import com.example.sydney.ui.theme.SydneyTheme

@Composable
fun SydneyApp() {
    val viewModel: SydneyViewModel = viewModel()
    val uiState by viewModel.uiState.collectAsState()

    SelectCategoryScreen(
        categories = uiState.categories
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SydneyAppBar(
    title: String,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = {
            Text(
                text = title,
                fontWeight = FontWeight.Bold
            )
        },
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "Back",
                        tint = MaterialTheme.colorScheme.onPrimary
                    )
                }
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            titleContentColor = MaterialTheme.colorScheme.onPrimary
        ),
        modifier = modifier,
    )
}

@Preview(showBackground = true)
@Composable
fun SportsAppBarPreview() {
    SydneyTheme(
        darkTheme = false
    ) {
        SydneyAppBar(
            title = stringResource(R.string.app_name),
            canNavigateBack = true
        )
    }
}