package timetable.service;

import timetable.entity.RouteEntity;
import timetable.entity.StationEntity;

import java.util.List;

public interface RouteService {
    List<RouteEntity> findAll() throws ServiceException;

    RouteEntity findById(Long id) throws ServiceException;

    void save(RouteEntity routeEntity) throws ServiceException;

    void delete(Long id) throws ServiceException;
}
