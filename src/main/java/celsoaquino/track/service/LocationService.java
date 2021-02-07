package celsoaquino.track.service;

import celsoaquino.track.Exception.LocationNotFoundException;
import celsoaquino.track.dto.mapper.LocationMapper;
import celsoaquino.track.dto.mapper.TrackerMapper;
import celsoaquino.track.dto.request.LocationDTO;
import celsoaquino.track.entity.Location;
import celsoaquino.track.entity.Tracker;
import celsoaquino.track.repository.LocationRepository;
import celsoaquino.track.repository.TrackerRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
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
    
    public Location create(@RequestBody Location location) throws LocationNotFoundException {
      Location saved = null;
        try {
          saved =  locationRepository.save(location);
      } catch (Exception e) {
          e.getMessage();
      }
        return saved;
    }
    
    public void deleteById( Long id) {
        locationRepository.deleteById(id);
    }

    public void update(Location location) {
      locationRepository.save(location);
    }


}