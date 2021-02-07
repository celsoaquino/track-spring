package celsoaquino.track.service;

import celsoaquino.track.Exception.LocationNotFoundException;
import celsoaquino.track.dto.mapper.TrackerMapper;
import celsoaquino.track.dto.request.TrackerDTO;
import celsoaquino.track.entity.Tracker;
import celsoaquino.track.repository.TrackerRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
        Tracker tracker = trackerRepository.findById(id)
                .orElseThrow(() -> new LocationNotFoundException(id));
        return trackerMapper.toDTO(tracker);
    }


}
