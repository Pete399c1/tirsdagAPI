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

Create a database with JPA and persist the data from the external APIs in the database. 
You should probably create the entities for Activity, CityInfo and WeatherInfo. 
Remember to add the Entities to the HibernateConfig file. 
Think about the relationships between Activity, CityInfo, and WeatherInfo when designing your entities. 
Consider using one-to-many or one-to-one relationships as needed, and ensure you annotate them properly with JPA annotations like @OneToMany, @ManyToOne, etc.
```
