package timetable.service;

import timetable.classes.Route;
import timetable.entity.TrackEntity;

import java.sql.SQLException;
import java.util.List;

public interface TrackService extends Service<TrackEntity> {
    List<Route> showAllroutes();
    String showFirstStation(long id) throws SQLException;
    String showLastStation(long id) throws SQLException;
    String showType(long id);
    List<Route> showRouteByStation(String name);
}
