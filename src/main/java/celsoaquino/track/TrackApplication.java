package celsoaquino.track;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class TrackApplication {
    public static void main(String[] args) {
        SpringApplication.run(TrackApplication.class, args);
    }
}
