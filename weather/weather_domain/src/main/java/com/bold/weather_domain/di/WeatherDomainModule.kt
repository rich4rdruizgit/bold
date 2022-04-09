package com.bold.weather_domain.di

import androidx.lifecycle.ViewModelProvider
import com.bold.weather_domain.repository.WeatherRepository
import com.bold.weather_domain.use_case.SearchLocation
import com.bold.weather_domain.use_case.WeatherUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelProvider::class)
object WeatherDomainModule {

    @ViewModelScoped
    @Provides
    fun provideWeatherUseCases(
        repository: WeatherRepository
    ): WeatherUseCases {
        return WeatherUseCases(
            searchLocation = SearchLocation(repository)
        )
    }
}