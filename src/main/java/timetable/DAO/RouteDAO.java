package timetable.DAO;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import timetable.classes.Station;
import timetable.entity.RouteEntity;

import java.util.List;
@Repository
public interface RouteDAO extends DAO<RouteEntity> {
    List<Station> showAllStations(long id);
}
