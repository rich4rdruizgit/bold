package com.bold.weather_domain.repository

import com.bold.weather_domain.model.LocationItem

interface WeatherRepository {
    suspend fun searchLocation(query:String):Result<List<LocationItem>>
}