package timetable.DAO;

import timetable.entity.RouteEntity;

import java.util.Date;
import java.util.List;

public interface RouteDAO extends Dao<RouteEntity> {
    List<String> showAllStations() throws DaoException;
}
