package com.bold.weather_data.remote

import com.bold.weather_data.remote.dto.LocationDto
import retrofit2.http.GET
import retrofit2.http.Query

interface MetaWeatherApi {

    @GET("location/search/?")
    suspend fun searchLocation(@Query("query") query: String):LocationDto

    companion object {
        const val BASE_URL = "https://www.metaweather.com/api/"
    }
}