package celsoaquino.track.service;

import celsoaquino.track.Exception.LocationNotFoundException;
import celsoaquino.track.dto.request.TrackerDTO;
import celsoaquino.track.entity.Location;
import celsoaquino.track.entity.Tracker;
import celsoaquino.track.repository.TrackerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class AsyncService {

    @Autowired
    private TrackerService trackerService;

    @Transactional
    @Async("asyncExecutor")
    public void updateTrack(Location location) {
        log.info("Initial async");
        Long id = location.getTrackerId();

        try {
            log.info("============= " +id);
            TrackerDTO tracker = trackerService.findById(id);
            log.info("---------- " +tracker.getName());
            tracker.setLatitude(location.getLatitude());
            tracker.setLongitude(location.getLongitude());
            trackerService.save(tracker);
        } catch (Exception e) {
          log.warn("Async ---------->>> " + e.getMessage());
        }
    }
}
