package com.bold.weather_data.repository

import com.bold.weather_data.remote.MetaWeatherApi
import com.bold.weather_domain.model.LocationItem
import com.bold.weather_domain.repository.WeatherRepository

class WeatherRepositoryImpl(private val api: MetaWeatherApi) : WeatherRepository {
    override suspend fun searchLocation(query: String): Result<List<LocationItem>> {
        return try {
            val searchDto = api.searchLocation(query)
            Result.success(
                searchDto.map { LocationItem(it.latLong, it.locationType, it.title, it.woeid) }
            )
        } catch (
            e: Exception
        ) {
            e.printStackTrace()
            Result.failure(e)
        }
    }
}