package com.bold.weather_data.repository

import com.bold.weather_data.remote.MetaWeatherApi
import com.bold.weather_domain.model.LocationItem
import com.bold.weather_domain.repository.WeatherRepository

class WeatherRepositoryImpl(private val api: MetaWeatherApi) : WeatherRepository {
    override suspend fun searchLocation(query: String): Result<List<LocationItem>> {
        TODO("Not yet implemented")
    }
}