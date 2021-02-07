package celsoaquino.track.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Tracker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double latitude;
    private Double longitude;

    @OneToMany(mappedBy = "trackerId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Location> locationList = new ArrayList<>();

    public Tracker addLocation(Location location) {
        locationList.add(location);
        location.setTrackerId(this.getId());
        return this;
    }


}
