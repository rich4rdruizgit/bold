package com.bold.weather_domain.model

data class LocationItem(
    val latLong: String,
    val locationType: String,
    val title: String,
    val woeid: Int
)