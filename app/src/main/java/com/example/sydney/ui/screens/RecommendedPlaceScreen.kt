package com.example.sydney.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.sydney.R
import com.example.sydney.data.LocalPlacesDataProvider
import com.example.sydney.model.Place
import com.example.sydney.ui.SydneyAppBar
import com.example.sydney.ui.theme.SydneyTheme

@Composable
fun RecommendedPlaceScreen(
    place: Place,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            SydneyAppBar(
                title = stringResource(place.nameResourceId),
                canNavigateBack = true,
                navigateUp = navigateUp
            )
        },
        modifier = modifier
    ) { innerPadding ->
        RecommendedPlaceBody(
            place = place,
            modifier = Modifier.padding(
                innerPadding
            )
        )
    }
}

@Composable
fun RecommendedPlaceBody(
    place: Place,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .padding(dimensionResource(R.dimen.padding_medium))
    ) {
        Image(
            painter = painterResource(place.largeImageResourceId),
            contentDescription = null,
            alignment = Alignment.Center,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = dimensionResource(R.dimen.padding_medium))
        )
        Text(
            text = stringResource(place.descResourceId),
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Preview(showBackground = true)
@Composable
fun RecommendedPlaceScreenPreview() {
    SydneyTheme {
        RecommendedPlaceScreen(
            LocalPlacesDataProvider.places[0],
            {}
        )
    }
}