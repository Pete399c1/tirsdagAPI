package app.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CityInfoDTO {
    private String name;
    private String geoCoordinates;
    private String municipality;
    private int population;

}
