package timetable.service;

import timetable.projections.StationProjection;
import timetable.entity.RouteEntity;

import java.util.List;

public interface RouteService extends Service<RouteEntity>{
    List<StationProjection> showAllStations(long id);
 }
