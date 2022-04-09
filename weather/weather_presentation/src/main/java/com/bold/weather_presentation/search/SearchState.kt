package com.bold.weather_presentation.search

data class SearchState(
    val query: String = "",
    val isHintVisible: Boolean = false,
    val isSearching: Boolean = false,
    val weatherLocations: List<WeatherLocatinUiState> = emptyList()
)