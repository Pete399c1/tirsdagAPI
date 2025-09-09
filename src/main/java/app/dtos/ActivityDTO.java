package app.dtos;

import app.enums.ActivityType;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ActivityDTO {
    private LocalDate exerciseDate;
    private ActivityType exerciseType;
    private LocalTime timeOfDay;
    private double duration;
    private double distance;
    private String comment;

    private WeatherInfoDTO weatherInfo;
    private CityInfoDTO cityInfo;
}
