package timetable.service;

import timetable.entity.StationEntity;

import java.util.List;

public interface StationService {
    List<StationEntity> findAll() throws ServiceException;

    StationEntity findById(Long id) throws ServiceException;

    void save(StationEntity stationEntity) throws ServiceException;

    void delete(Long id) throws ServiceException;
}
