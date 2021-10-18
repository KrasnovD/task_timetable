package timetable.DAO;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import timetable.entity.RouteEntity;
import timetable.entity.StationEntity;

import java.util.List;

@Repository
public interface StationDAO extends DAO<StationEntity, Long> {
    @Query("SELECT s FROM station s")
    List<StationEntity> findAll();
}
