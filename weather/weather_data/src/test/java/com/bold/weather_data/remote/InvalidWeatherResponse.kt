package com.bold.weather_domain.remote

val malformedWeatherResponse = """
    [
        {
            "title": "Sunderland",
            "location_type": "City",
            "woeid": 36615,
            "latt_long": "54.900120,-1.408480"
        ,
        {
            "title": "Surat",
            "location_type": "City",
            "woeid": 2295405,
            "latt_long": "21.165131,72.836182"
        }
    ]
""".trimIndent()