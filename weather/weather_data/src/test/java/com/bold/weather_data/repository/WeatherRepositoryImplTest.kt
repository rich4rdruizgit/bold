package com.bold.weather_data.repository

import com.bold.weather_data.remote.MetaWeatherApi
import com.bold.weather_domain.remote.malformedWeatherResponse
import com.google.common.truth.Truth.assertThat
import com.bold.weather_domain.remote.validWeatherResponse
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

class WeatherRepositoryImplTest {

    private lateinit var repository: WeatherRepositoryImpl
    private lateinit var mockWebServer: MockWebServer
    private lateinit var okHttpClient: OkHttpClient
    private lateinit var api: MetaWeatherApi

    @Before
    fun setUp() {
        mockWebServer = MockWebServer()
        okHttpClient = OkHttpClient.Builder()
            .writeTimeout(1, TimeUnit.SECONDS)
            .readTimeout(1, TimeUnit.SECONDS)
            .connectTimeout(1, TimeUnit.SECONDS)
            .build()
        api = Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create())
            .client(okHttpClient)
            .baseUrl(mockWebServer.url("/"))
            .build()
            .create(MetaWeatherApi::class.java)
        repository = WeatherRepositoryImpl(
            api = api
        )
    }

    @After
    fun tearDown(){
        mockWebServer.shutdown()
    }

    @Test
    fun `Search location, valid response, returns results`() = runBlocking {
        mockWebServer.enqueue(
            MockResponse()
                .setResponseCode(200)
                .setBody(validWeatherResponse)
        )
        val result = repository.searchLocation("su")

        assertThat(result.isSuccess).isTrue()
    }

    @Test
    fun `Search location, invalid response, returns failure`() = runBlocking {
        mockWebServer.enqueue(
            MockResponse()
                .setResponseCode(403)
                .setBody(validWeatherResponse)
        )
        val result = repository.searchLocation("su")

        assertThat(result.isFailure).isTrue()
    }

    @Test
    fun `Search food, malformed response, returns failure`() = runBlocking {
        mockWebServer.enqueue(
            MockResponse()
                .setBody(malformedWeatherResponse)
        )
        val result = repository.searchLocation("su")

        assertThat(result.isFailure).isTrue()
    }

}