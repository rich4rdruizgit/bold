# Prueba Técnica Bold
En esta prueba se hace uso del API MetaWheater que se provee en el enunciado de la prueba.

## ¿Qué se desarrolló en la prueba?
Se crea el presente repositorio donde se utiliza el marco de trabajo de GitFlow para equipos de desarrollo.
- Rama inicial main
- Rama de desarrollo develop
- Rama de funcionalidades que llevan la nomenclatura feature/(description)

El desarrollo se segmentó en diferentes etapas:
- ***Etapa de creación del repositorio y enlace con la base inicial del proyecto creado en android.***
- **Etapa de creación del modulo de Kotlin DSL:** Esta etapa se centra en crear un módulo que nos permitirá gestionar las dependencias con lenguaje Kotlin de una manera modularizada y centralizada. [feature/configuration](https://github.com/rich4rdruizgit/bold/tree/feature/configuration)
- **Etapa de creación de arquitectura multimodular:** Se genera una arquitectura multimodular donde se divide en responsabilidades diferentes funcionalidades con el fin de que si a futuro la app escala, esta pueda hacerlo de una manera flexible y natural. [feature/moduleConfiguration](https://github.com/rich4rdruizgit/bold/tree/feature/moduleConfiguration)
- **Etapa de implementación de clean architecture:** Esta etapa se centra en el desarrollo del planteamiento de la arquitectura con la que se construiran las diferentes funcionalidades. Se crea un modulo contenedor el cual encapsula diferentes funcionalidades similares a la que se relaciona con su nombre en la definición del dominio de negocio, buscar ubicación. Se crean tres modulos diferentes WeatherDomain, WeatherData, WeatherPresentación, donde de una menera limpia se genera la implementación.  [feature/cleanArchitectureModules](https://github.com/rich4rdruizgit/bold/tree/feature/cleanArchitectureModules).
- **Etapa de implementación de Kotlin DSL:** Dado que al generar diferentes módulos en el proyecto se van a generar "n" cantidad de archivos "gradle", es necesario implementar una estrategia que optmice el manejo de dependencias a nivel de todo el proyecto. Por ello se crean dos Gradle Padres, uno con deberes de UI y otro con deberes de implementación, los cuales heredan depedencias a gradles hijos.[feature/setupKotlinDSL](https://github.com/rich4rdruizgit/bold/tree/feature/setupKotlinSDL)
- **Etapa de implementación del feature:** - Se centra en el desarrollo total del unico caso de uso implementado en esta prueba, que es el de busqueda, el cual está muy completo ya que tiene una implementación multimodular a nivel de todo el proyecto, que además encapsula clean architecture y diferentes patrones de UI como MVVM, Inyección de dependencias, etc.[feature/search](https://github.com/rich4rdruizgit/bold/tree/feature/search)
- **Etapa de pruebas unitarias:** Esta etapa se hacen un par de test unitarios de la capa de data, de la estructura remota que almacena la implementación del repositorio. [feature/unitTest](https://github.com/rich4rdruizgit/bold/tree/test/unitTest)


## Imagenes de los resultados
 
- **Búsqueda de ubicaciones cuando existe** 

![alt text](https://github.com/rich4rdruizgit/bold/blob/main/image/result.jpeg)

- **Búsqueda de ubicaciones cuando no hay data** 

![alt text](https://github.com/rich4rdruizgit/bold/blob/main/image/noresult.jpeg)

- **Algunas pruebas unitarias** 

![alt text](https://github.com/rich4rdruizgit/bold/blob/main/image/unitTest.PNG)



Explicando un poco la mecanica...

- En la barra de estados se creó un Widget personalizado para simular el estilo y color de la tipografia de Rick and Morty
- En el chat los elementos que no tienen el icono azul , significa que en su ESTADO es Dead



## ¿Cómo implementaria las funcionalidades faltantes?
- La funcionalidad pendiente es mostrar el detalle de la ubicación, donde se evidencie la predicción del clima en los siguientes dias.
`
{
    "consolidated_weather": [
        {
            "id": 4703811047260160,
            "weather_state_name": "Heavy Cloud",
            "weather_state_abbr": "hc",
            "wind_direction_compass": "ESE",
            "created": "2022-04-09T23:19:25.073534Z",
            "applicable_date": "2022-04-10",
            "min_temp": 1.78,
            "max_temp": 9.844999999999999,
            "the_temp": 9.34,
            "wind_speed": 4.439743364757814,
            "wind_direction": 120.31639680319255,
            "air_pressure": 1018.0,
            "humidity": 53,
            "visibility": 13.626359560168614,
            "predictability": 71
            }
    ],
    "time": "2022-04-10T00:38:39.412363+01:00",
    "sun_rise": "2022-04-10T06:15:14.944514+01:00",
    "sun_set": "2022-04-10T19:59:55.533391+01:00",
    "timezone_name": "LMT",
    "parent": {
        "title": "England",
        "location_type": "Region / State / Province",
        "woeid": 24554868,
        "latt_long": "52.883560,-1.974060"
    },
    "sources": [
        {
            "title": "BBC",
            "slug": "bbc",
            "url": "http://www.bbc.co.uk/weather/",
            "crawl_rate": 360
        },
        {
            "title": "Forecast.io",
            "slug": "forecast-io",
            "url": "http://forecast.io/",
            "crawl_rate": 480
        },
        {
            "title": "Met Office",
            "slug": "met-office",
            "url": "http://www.metoffice.gov.uk/",
            "crawl_rate": 180
        },
        {
            "title": "OpenWeatherMap",
            "slug": "openweathermap",
            "url": "http://openweathermap.org/",
            "crawl_rate": 360
        },
        {
            "title": "World Weather Online",
            "slug": "world-weather-online",
            "url": "http://www.worldweatheronline.com/",
            "crawl_rate": 360
        }
    ],
    "title": "Sunderland",
    "location_type": "City",
    "woeid": 36615,
    "latt_long": "54.900120,-1.408480",
    "timezone": "Europe/London"
}
`

**Implementación en capa de datos Weather-data**
-Agrego el método detail() en el Api
-Genero su respectivo DTO
-Genero su implementación en el repositorio de data WeatherRepositoryImpl

**Implementación en capa de dominio**
-Agrego el mapeo del DTO de detalle a un modelo de negocio de la aplicación.
-Creo el caso de uso de obtener el detalle de la ubicación.
-Agrego el caso de uso a el caso de uso general
-Genero la declaración de los métodos del repositorio en la interfaz.
-Impacto el modulo de DI para agregar el caso de uso

**Implementación de capa de presentación**
-Agrego un apartado para el detalle
-Creo el ViewModel de detalle inyectandole el caso de uso correspondiente
-Genero los posibles estados de la vista
-Genero el Screen de detalle

**Impactando modulo App de Navegación**
-Genero la navegación para ir de la busqueda al detalle.

***It's done!!!**

***Agradezco la atención y disposición por revisar la prueba técnica***


