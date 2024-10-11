package com.example.sydney.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.sydney.R
import com.example.sydney.data.LocalCategoriesDataProvider
import com.example.sydney.ui.theme.SydneyTheme

@Composable
fun SydneyApp() {
    Scaffold(
        topBar = {
            SydneyAppBar()
        }
    ) { innerPadding ->
        SelectionScreen(
            LocalCategoriesDataProvider.appCategories,
            modifier = Modifier.padding(horizontal = dimensionResource(R.dimen.padding_medium)),
            contentPadding = innerPadding
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SydneyAppBar(
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = {
            Text(
                text = stringResource(R.string.app_name),
                fontWeight = FontWeight.Bold
            )
        },
//        navigationIcon = if (isShowingDetailPage) {
//            {
//                IconButton(onClick = onBackButtonClick) {
//                    Icon(
//                        imageVector = Icons.Filled.ArrowBack,
//                        contentDescription = stringResource(R.string.back_button)
//                    )
//                }
//            }
//        } else {
//            { Box {} }
//        },
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
    SydneyTheme() {
        SydneyAppBar()
    }
}