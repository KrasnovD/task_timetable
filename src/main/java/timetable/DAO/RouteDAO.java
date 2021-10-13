package timetable.DAO;

import org.springframework.stereotype.Repository;
import timetable.classes.Station;
import timetable.entity.RouteEntity;

import java.util.List;
@Repository
public interface RouteDAO extends Dao<RouteEntity> {
    List<Station> showAllStations(long id);
}
