package com.bold.weather_presentation.search

import com.bold.weather_domain.model.LocationItem

data class WeatherLocatinUiState(
    val location: LocationItem,
    val isExpanded: Boolean = false
)