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

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

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

    }

}