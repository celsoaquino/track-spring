package celsoaquino.track.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TrackerDTO {

    private Long id;
    private String name;
    private Double latitude;
    private Double longitude;

    /*@JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<LocationDTO> locationList;*/
}
