package timetable.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import timetable.entity.Track;

public interface TrackRepository extends JpaRepository<Track, Long> {
}
