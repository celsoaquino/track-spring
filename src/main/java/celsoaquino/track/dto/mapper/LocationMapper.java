package celsoaquino.track.dto.mapper;


import celsoaquino.track.dto.request.LocationDTO;
import celsoaquino.track.entity.Location;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface LocationMapper {

    LocationMapper INSTANCE = Mappers.getMapper(LocationMapper.class);

    Location toModel(LocationDTO locationDTO);

    LocationDTO toDTO(Location location);
}
