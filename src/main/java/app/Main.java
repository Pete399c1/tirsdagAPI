package app;




import app.dtos.ActivityDTO;
import app.dtos.CityInfoDTO;
import app.dtos.WeatherInfoDTO;
import app.enums.ActivityType;
import app.services.CityService;
import app.services.WeatherService;

import java.io.IOException;
import java.time.LocalDate;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        /*
        WeatherInfoDTO weatherInfo = WeatherService.fetchWeatherDataByLocationName("Roskilde");
        CityInfoDTO cityInfo = CityService.getCityInfo("Roskilde");

        ActivityDTO activityDTO = ActivityDTO
                .builder()
                .exerciseType(ActivityType.RUNNING)
                .cityInfo(cityInfo)
                .distance(6.5)
                .exerciseDate(LocalDate.now())
                .duration(30.0)
                .timeOfDay(LocalTime.of(15, 45))
                .comment("Lovely downhill stroll")
                .cityInfo(cityInfo)
                .weatherInfo(weatherInfo)
                .build();

        System.out.println(activityDTO);

        WeatherInfoDTO weatherInfo1 = WeatherService.fetchWeatherDataByLocationName("København");
        CityInfoDTO cityInfo1 = CityService.getCityInfo("København");

        ActivityDTO activityDTO1 = ActivityDTO.builder()
                .exerciseType(ActivityType.SKATING)
                .cityInfo(cityInfo1)
                .distance(7.8)
                .exerciseDate(LocalDate.now())
                .duration(50.0)
                .timeOfDay(LocalTime.of(17,32))
                .comment("skatepark grinding")
                .cityInfo(cityInfo1)
                .weatherInfo(weatherInfo1)
                .build();

        System.out.println(activityDTO1);
         */

        //setting up for two threads to get the city and weather data into the dto s
        ExecutorService executor = Executors.newFixedThreadPool(2);


        //A list to save Future objects future represents a result of an assignment that is not finished yet
        List<Future<ActivityDTO>> futures = new ArrayList<>();

        //future for Roskilde
        Future<ActivityDTO> futureRos = executor.submit(() -> {
            try {
                // getting the city
                CityInfoDTO cityInfo = CityService.getCityInfo("Roskilde");
                // getting the weather data by using the city name
                WeatherInfoDTO weatherInfo = WeatherService.fetchWeatherDataByLocationName("Roskilde");

                // building the activityDTO for Roskilde
                return ActivityDTO.builder()
                        .exerciseDate(LocalDate.now())
                        .exerciseType(ActivityType.RUNNING)
                        .timeOfDay(LocalTime.of(17, 33))
                        .distance(7.6)
                        .duration(40.0)
                        .comment("A trip around the city")
                        .cityInfo(cityInfo)
                        .weatherInfo(weatherInfo)
                        .build();

            } catch (Exception e) {
                throw new RuntimeException("Failed trying to get the data: ", e);
            }
        });
        // adding future to the list so that we can get the result by f.get
        futures.add(futureRos);



        //future for kbh
        Future<ActivityDTO> futureKbh = executor.submit(() ->{
        try {
            CityInfoDTO cityInfo = CityService.getCityInfo("København");
            WeatherInfoDTO weatherInfo = WeatherService.fetchWeatherDataByLocationName("København");

            return ActivityDTO.builder()
                    .exerciseDate(LocalDate.of(2025, 11,4))
                    .exerciseType(ActivityType.SKATING)
                    .timeOfDay(LocalTime.of(13,00))
                    .distance(10.0)
                    .duration(60.0)
                    .comment("Street skating")
                    .cityInfo(cityInfo)
                    .weatherInfo(weatherInfo)
                    .build();
        }catch(Exception e) {
            throw new RuntimeException("Failed trying to get the data", e);
        }

    });
        futures.add(futureKbh);


        for (Future<ActivityDTO> f : futures){
            try {
                // get the result
                ActivityDTO dto = f.get();
                System.out.println(dto);
            }catch (ExecutionException e){
                e.getCause().printStackTrace();
            }
        }
        // closing the service new assignments
        executor.shutdown();
    }

}