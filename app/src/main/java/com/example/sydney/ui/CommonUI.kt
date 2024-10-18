package com.example.sydney.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sydney.R
import com.example.sydney.data.LocalPlacesDataProvider
import com.example.sydney.model.Category
import com.example.sydney.model.Option
import com.example.sydney.ui.theme.SydneyTheme

@Composable
fun <T: Option> SelectionScreen(
    categories: List<T>,
    onCategoryClick: (T) -> Unit,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp)
) {
    LazyColumn(
        contentPadding = contentPadding,
        verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_medium)),
        modifier = modifier.padding(dimensionResource(R.dimen.padding_medium)),
    ) {
        items(categories, key = { category -> category.id }) { category ->
            CategoriesListItem(
                category = category,
                onItemClick = onCategoryClick
            )
        }
    }
}

@Composable
private fun <T: Option> CategoriesListItem(
    category: T,
    onItemClick: (T) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        elevation = CardDefaults.cardElevation(),
        modifier = modifier,
        shape = RoundedCornerShape(dimensionResource(R.dimen.card_corner_radius)),
        onClick = { onItemClick(category) }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .size(dimensionResource(R.dimen.card_image_height)),
            verticalAlignment = Alignment.CenterVertically
        ) {
            CategoriesListImageItem(
                category = category,
                modifier = Modifier.size(dimensionResource(R.dimen.card_image_height))
            )

            val textStyle = if (category is Category) MaterialTheme.typography.displaySmall else MaterialTheme.typography.headlineLarge

            Text(
                text = stringResource(category.nameResourceId),
                style = textStyle,
                modifier = Modifier
                    .padding(dimensionResource(R.dimen.padding_small))
                    .weight(1f),
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.secondary
            )
        }
    }
}

@Composable
private fun <T: Option> CategoriesListImageItem(category: T, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
    ) {
        Image(
            painter = painterResource(category.imageResourceId),
            contentDescription = null,
            alignment = Alignment.Center,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SydneyAppBar(
    title: String,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    val titleColor = MaterialTheme.colorScheme.secondary
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
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back",
                        tint = titleColor
                    )
                }
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = titleColor
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

@Preview(showBackground = true)
@Composable
fun CategoriesListItemPreview() {
    SydneyTheme {
        CategoriesListItem(
            category = LocalPlacesDataProvider.places[10],
            {}
        )
    }
}