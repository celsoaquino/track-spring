package celsoaquino.track.controller;

import celsoaquino.track.Exception.LocationNotFoundException;
import celsoaquino.track.dto.request.LocationDTO;
import celsoaquino.track.entity.Location;
import celsoaquino.track.service.AsyncService;
import celsoaquino.track.service.LocationService;
import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@Slf4j
@AllArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/locations")
public class LocationController {

    private final AsyncService service;

    private final LocationService locationService;

    @GetMapping
    public List<LocationDTO> listAll() {
        return locationService.listAll();
    }

    @GetMapping("/{id}")
    public Optional<Location> list(@PathVariable Long id) {
        return locationService.list(id);
    }

    @PostMapping
    @ResponseBody
    public Location create(@RequestBody Location location)  {
        location.setDateTime(LocalDateTime.now());
        log.info("testAsync Start");
        service.updateTrack(location);

        return locationService.create(location);
    }

    @PatchMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody Map<Object, Object> fields) {
        Location updateLocation = locationService.list(id).orElse(null);
        fields.forEach((k, v) -> {
            Field field = ReflectionUtils.findField(Location.class, (String) k);
            field.setAccessible(true);
            ReflectionUtils.setField(field, updateLocation, v);
        });
        locationService.update(updateLocation);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        locationService.deleteById(id);
    }

}
