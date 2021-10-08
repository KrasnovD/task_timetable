package timetable.service;

import timetable.classes.Route;
import timetable.entity.StationEntity;
import timetable.entity.TrackEntity;

import java.util.List;

public interface TrackService extends Service<TrackEntity> {
    List<Route> showAllroutes() throws ServiceException;
}
