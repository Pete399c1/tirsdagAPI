```
Take a close look at the domain model and the external APIs. What data do you need to get from the APIs? What data do you need to store in the ActivityDTO?

Create a WeatherInfoDTO and a CityInfoDTO that can hold the data from the external APIs.

Create an ActivityDTO that can hold the data from the external APIs + extra data that you might want to add.

Create a WeatherService and a CityService that can fetch data from the external APIs and return the data in the form of a WeatherInfoDTO and a CityInfoDTO.

Create a ActivityService that can create an ActivityDTO and enrich it with data from the WeatherService and the CityService.

//Create a integration test that can test the ActivityService and the WeatherService and the CityService.
```

```
Change your code to use threads and executor service to get the city and weather data into your DTOs
```
