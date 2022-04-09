package com.bold.weather_presentation.search.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import com.bold.core_ui.LocalSpacing
import com.bold.weather_presentation.search.WeatherLocatinUiState


@ExperimentalCoilApi
@Composable
fun WeatherLocationItem(
    weatherLocatinUiState: WeatherLocatinUiState,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val location = weatherLocatinUiState.location
    val spacing = LocalSpacing.current
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(5.dp))
            .padding(spacing.spaceExtraSmall)
            .shadow(
                elevation = 1.dp,
                shape = RoundedCornerShape(5.dp)
            )
            .background(MaterialTheme.colors.surface)
            .clickable { onClick() }
            .padding(end = spacing.spaceMedium)
    ) {
        Text(location.title, fontWeight = FontWeight.Bold)
        Text(text = location.locationType, style = MaterialTheme.typography.body2)
    }
}