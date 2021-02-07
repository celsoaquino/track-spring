package celsoaquino.track.dto.request;

import celsoaquino.track.entity.Tracker;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LocationDTO {

    private Long id;
    private Long trackerId;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private Date dateTime;
    private Double latitude;
    private Double longitude;


}
