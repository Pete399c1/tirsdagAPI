package app.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class WeatherInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Double temperature;
    private String skyText;
    private String humidity;
    private String windText;

    @OneToOne(mappedBy = "weatherInfo")
    private Activity activity;
}
