package timetable.service;

import timetable.classes.Route;
import timetable.classes.Station;
import timetable.entity.RouteEntity;
import timetable.entity.StationEntity;

import java.util.List;

public interface RouteService extends Service<RouteEntity>{
    List<Station> showAllStations() throws ServiceException;
 }
