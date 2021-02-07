package celsoaquino.track.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Tracker {

    @Id
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
