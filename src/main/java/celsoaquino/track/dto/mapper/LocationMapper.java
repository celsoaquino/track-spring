package celsoaquino.track.dto.mapper;


import celsoaquino.track.dto.request.LocationDTO;
import celsoaquino.track.dto.request.TrackerDTO;
import celsoaquino.track.entity.Location;
import celsoaquino.track.entity.Tracker;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface LocationMapper {

    LocationMapper INSTANCE = Mappers.getMapper(LocationMapper.class);

    Location toModel(LocationDTO locationDTO);

    LocationDTO toDTO(Location location);
}
