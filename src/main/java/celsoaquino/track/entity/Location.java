package celsoaquino.track.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private ZonedDateTime dateTime;
    private Double latitude;
    private Double longitude;
    private Long trackerId;

    public void setDateTime(LocalDateTime dateTime) {
        ZonedDateTime br = dateTime.atZone(ZoneId.of("Brazil/east"));

        this.dateTime = br;
    }
}
