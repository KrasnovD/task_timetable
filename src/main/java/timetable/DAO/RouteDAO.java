package timetable.DAO;

import timetable.classes.Route;
import timetable.classes.Station;
import timetable.entity.RouteEntity;

import java.sql.SQLException;
import java.util.List;

public interface RouteDAO extends Dao<RouteEntity> {
    List<Station> showAllStations() throws DaoException;
}
