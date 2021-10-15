package timetable.service;

import timetable.classes.Route;
import timetable.entity.TrackEntity;

import java.sql.SQLException;
import java.util.List;

public interface TrackService extends Service<TrackEntity> {
    List<Route> showAllroutes() throws SQLException;
    String showFirstStation(long id);
    String showLastStation(long id);
    String showType(long id);
    List<Route> showRouteByStation(String name) throws SQLException;
}
