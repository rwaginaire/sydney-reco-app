package com.example.sydney.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.sydney.R
import com.example.sydney.data.LocalPlacesDataProvider
import com.example.sydney.model.Category
import com.example.sydney.model.Place
import com.example.sydney.ui.theme.SydneyTheme

@Composable
private fun PlacesListItem(
    place: Place,
    onItemClick: (Place) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        elevation = CardDefaults.cardElevation(),
        modifier = modifier,
        shape = RoundedCornerShape(dimensionResource(R.dimen.card_corner_radius)),
        onClick = { onItemClick(place) }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .size(dimensionResource(R.dimen.card_image_height)),
            verticalAlignment = Alignment.CenterVertically
        ) {
            PlacesListImageItem(
                place = place,
                modifier = Modifier.size(dimensionResource(R.dimen.card_image_height))
            )

            Text(
                text = stringResource(place.nameResourceId),
                style = MaterialTheme.typography.displaySmall,
                modifier = Modifier
                    .padding(bottom = dimensionResource(R.dimen.card_text_vertical_space))
                    .weight(1f),
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
private fun PlacesListImageItem(place: Place, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
    ) {
        Image(
            painter = painterResource(place.iconResourceId),
            contentDescription = null,
            alignment = Alignment.Center,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PlacesListItemPreview() {
    SydneyTheme {
        PlacesListItem(
            LocalPlacesDataProvider.places[1],
            {}
        )
    }
}