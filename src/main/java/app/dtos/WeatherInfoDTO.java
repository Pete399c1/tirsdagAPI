package app.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WeatherInfoDTO {
    private double temperature;
    private String skyText;
    private double humidity;
    private String windText;
}
