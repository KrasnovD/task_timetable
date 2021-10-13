package timetable.service;

import timetable.classes.Station;
import timetable.entity.RouteEntity;

import java.util.List;

public interface RouteService extends Service<RouteEntity>{
    List<Station> showAllStations(long id);
 }
