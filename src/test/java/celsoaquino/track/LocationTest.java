package celsoaquino.track;

import celsoaquino.track.entity.Location;
import celsoaquino.track.repository.LocationRepository;
import celsoaquino.track.service.AsyncService;
import celsoaquino.track.service.LocationService;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@SpringBootTest
public class LocationTest {

    @Autowired
    LocationRepository service;


    @Test
    public void insertLocation() throws URISyntaxException, InterruptedException {
        RestTemplate restTemplate = new RestTemplate();
        final String baseUrl = "http://localhost:8080/locations";
        URI uri = new URI(baseUrl);
        Faker faker = new Faker();
        int qtd = 100;
        while (qtd > 0) {
            Thread.sleep(1000l);
            Location location = new Location();
            location.setTrackerId(654321L);
            location.setLongitude((faker.random().nextDouble() * 180) - 90);
            location.setLatitude((faker.random().nextDouble() * 360) - 180);
            restTemplate.postForEntity(uri, location, Location.class);
            qtd--;
        }
        Assertions.assertEquals(0, qtd);
    }
}
