package celsoaquino.track.service;

import celsoaquino.track.dto.mapper.LocationMapper;
import celsoaquino.track.dto.request.LocationDTO;
import celsoaquino.track.entity.Location;
import celsoaquino.track.repository.LocationRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Log4j2
@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class LocationService {

    private final LocationRepository locationRepository;

    private final LocationMapper locationMapper;


    public List<LocationDTO> listAll() {
        List<Location> locations = locationRepository.findAll();
        return locations.stream()
                .map(locationMapper::toDTO)
                .collect(Collectors.toList());
    }
    
    public Optional<Location> list(Long id) {
        return locationRepository.findById(id);
    }
    
    public Location create( Location location) {
        try {
            return  locationRepository.save(location);
        } catch (Exception e) {
            log.error(e.getMessage());
        }

     return null;
    }
    
    public void deleteById( Long id) {
        locationRepository.deleteById(id);
    }

    public void update(Location location) {
      locationRepository.save(location);
    }


}