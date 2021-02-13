package celsoaquino.track.dto.mapper;


import celsoaquino.track.dto.request.TrackerDTO;
import celsoaquino.track.entity.Tracker;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;


@Mapper(uses = {LocationMapper.class})
public interface TrackerMapper {

    TrackerMapper INSTANCE = Mappers.getMapper(TrackerMapper.class);

    Tracker toModel(TrackerDTO trackerDTO);

    //@Mapping(source = "tracker.locationList", target = "locationList")
    TrackerDTO toDTO(Tracker tracker);
}
