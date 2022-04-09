package com.bold.weather_data.di

import com.bold.weather_data.remote.MetaWeatherApi
import com.bold.weather_data.repository.WeatherRepositoryImpl
import com.bold.weather_domain.repository.WeatherRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object WeatherDataModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(
                HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                }
            )
            .build()
    }

    @Provides
    @Singleton
    fun provideMetaWeatherApi(client: OkHttpClient): MetaWeatherApi {
        return Retrofit.Builder()
            .baseUrl(MetaWeatherApi.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .client(client)
            .build()
            .create()
    }

    @Provides
    @Singleton
    fun provideWeatherRepository(
        api: MetaWeatherApi
    ): WeatherRepository {
        return WeatherRepositoryImpl(
            api = api
        )
    }
}