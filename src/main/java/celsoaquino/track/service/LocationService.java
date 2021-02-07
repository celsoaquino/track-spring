package celsoaquino.track.service;

import celsoaquino.track.Exception.LocationNotFoundException;
import celsoaquino.track.dto.mapper.LocationMapper;
import celsoaquino.track.dto.request.LocationDTO;
import celsoaquino.track.entity.Location;
import celsoaquino.track.repository.LocationRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
      return  locationRepository.save(location);
    }
    
    public void deleteById( Long id) {
        locationRepository.deleteById(id);
    }

    public void update(Location location) {
      locationRepository.save(location);
    }


}