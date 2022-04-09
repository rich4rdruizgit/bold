package com.bold.weather_domain.use_case

import com.bold.weather_domain.model.LocationItem
import com.bold.weather_domain.repository.WeatherRepository

class SearchLocation(
    private val repository: WeatherRepository
) {
    suspend operator fun invoke(query: String): Result<List<LocationItem>> {
        if(query.isBlank()){
            return Result.success(emptyList())
        }
        return repository.searchLocation(query.trim())
    }
}