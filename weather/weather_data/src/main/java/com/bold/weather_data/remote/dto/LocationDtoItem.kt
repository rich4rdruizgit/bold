package com.bold.weather_data.remote.dto

import com.squareup.moshi.Json

data class LocationDtoItem(
    @field:Json(name = "latt_long")
    val latLong: String,
    @field:Json(name = "location_type")
    val locationType: String,
    val title: String,
    val woeid: Int
)