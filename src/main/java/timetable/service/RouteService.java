package timetable.service;

import timetable.entity.RouteEntity;
import timetable.entity.StationEntity;

import java.util.List;

public interface RouteService extends Service<RouteEntity>{
    List<String> showAllStations() throws ServiceException;
 }
