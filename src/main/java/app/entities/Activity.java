package app.entities;

import app.dtos.CityInfoDTO;
import app.dtos.WeatherInfoDTO;
import app.enums.ActivityType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode
@ToString
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private LocalDate exerciseDate;

    @Enumerated(EnumType.STRING)
    private ActivityType exerciseType;

    private LocalTime timeOfDay;
    private double duration;
    private double distance;
    private String comment;

    @OneToOne(cascade = CascadeType.ALL)
    private WeatherInfo weatherInfo;

    @ManyToOne(cascade = CascadeType.ALL)
    private CityInfo cityInfo;
}
