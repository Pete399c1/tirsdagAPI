package app.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ActivityDTO {
    private String exerciseDate;
    private String exerciseType;
    private String timeOfDay;
    private int duration;
    private double distance;
    private String comment;

    private WeatherInfoDTO weatherInfo;
    private CityInfoDTO cityInfo;
}
