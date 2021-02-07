package celsoaquino.track;

import celsoaquino.track.entity.Tracker;
import celsoaquino.track.repository.TrackerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TrackerRunner implements CommandLineRunner {

    @Autowired
    private TrackerRepository service;

    @Override
    public void run(String... args) throws Exception {
      Tracker tracker = new Tracker();
      tracker.setId(654321L);
      tracker.setName("Meu rastreador");
      tracker.setLatitude(-23.9626767);
      tracker.setLongitude(-46.3884785);
      service.save(tracker);
    }
}
