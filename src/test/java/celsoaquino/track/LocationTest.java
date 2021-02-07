package celsoaquino.track;

import celsoaquino.track.entity.Location;
import celsoaquino.track.repository.LocationRepository;
import celsoaquino.track.service.LocationService;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@SpringBootTest
public class LocationTest {

    @Autowired
    LocationRepository service;


    @Test
    public void insertLocation() {
        Faker faker = new Faker();
        int qtd = 100;


        while (qtd > 0) {
            Location location = new Location();
            location.setTrackerId(1L);
            location.setDateTime(LocalDateTime.now());
            location.setLongitude((faker.random().nextDouble() * 180) - 90);
            location.setLatitude((faker.random().nextDouble() * 360) - 180);
            service.save(location);
            qtd--;
        }

    }
}
