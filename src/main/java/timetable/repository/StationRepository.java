package timetable.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import timetable.entity.Station;

@Repository
public interface StationRepository extends JpaRepository<Station, Long> {
}
