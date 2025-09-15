package app.entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
public class CityInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private String primaryName;
    private String href;
    private double Longitude;
    private double Latitude;

    @OneToMany(mappedBy = "cityInfo")
    private List<Activity> activities;
}
