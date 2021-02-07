package celsoaquino.track.service;

import celsoaquino.track.Exception.LocationNotFoundException;
import celsoaquino.track.dto.request.TrackerDTO;
import celsoaquino.track.entity.Location;
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
    public void updateTrack(Location location) throws InterruptedException, LocationNotFoundException {
        log.info("Initial async");
        try {
            Long id = location.getTrackerId();
            TrackerDTO tracker = trackerService.findById(id);
            tracker.setLatitude(location.getLatitude());
            tracker.setLongitude(location.getLongitude());
            trackerService.save(tracker);
        } catch (Exception e) {
          log.warn("---------->>>" +e.getMessage());
        }
    }
}
