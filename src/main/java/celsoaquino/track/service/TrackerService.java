package celsoaquino.track.service;

import celsoaquino.track.Exception.LocationNotFoundException;
import celsoaquino.track.dto.mapper.TrackerMapper;
import celsoaquino.track.dto.request.TrackerDTO;
import celsoaquino.track.entity.Tracker;
import celsoaquino.track.repository.TrackerRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Log4j2
@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class TrackerService {


    private final TrackerRepository trackerRepository;

    private final TrackerMapper trackerMapper = TrackerMapper.INSTANCE;


    public List<TrackerDTO> findAll() {
        List<Tracker> trackers = trackerRepository.findAll();

        return trackers.stream()
                .map(trackerMapper::toDTO)
                .collect(Collectors.toList());
    }

    public void save(TrackerDTO trackerDTO) {
        Tracker tracker = trackerMapper.toModel(trackerDTO);
        trackerRepository.save(tracker);
    }

    public TrackerDTO findById(Long id) throws LocationNotFoundException {
        Tracker tracker = null;
        try {
            tracker = trackerRepository.findById(id).get();
            return trackerMapper.toDTO(tracker);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
       return null;
    }
}
