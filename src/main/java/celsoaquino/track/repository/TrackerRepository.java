package celsoaquino.track.repository;

import celsoaquino.track.entity.Tracker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrackerRepository extends JpaRepository<Tracker, Long> {
}
