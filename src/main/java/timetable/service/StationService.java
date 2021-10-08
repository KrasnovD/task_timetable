package timetable.service;

import timetable.entity.StationEntity;

import java.util.List;

public interface StationService extends Service<StationEntity> {
    List<String> showAllStations(Long id) throws ServiceException;
}
