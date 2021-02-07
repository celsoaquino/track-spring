package celsoaquino.track.controller;

import celsoaquino.track.dto.request.TrackerDTO;
import celsoaquino.track.service.TrackerService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class TrackerController {

    private final TrackerService trackerService;

    @GetMapping("/tracker")
    public List<TrackerDTO> findAll() {
        return trackerService.findAll();
    }

    @PostMapping("/tracker")
    public void create(@RequestBody TrackerDTO trackerDTO) {
        trackerService.save(trackerDTO);
    }
}
