package app.dtos;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ActivityDTO {
    private LocalDate exerciseDate;
    private ActivityDTO exerciseType;
    private LocalTime timeOfDay;
    private double duration;
    private double distance;
    private String comment;

    private WeatherInfoDTO weatherInfo;
    private CityInfoDTO cityInfo;
}
