package timetable.service;

import timetable.entity.Entity;
import timetable.entity.StationEntity;

import java.util.List;

public interface Service<T extends Entity> {
    List<T> findAll() throws ServiceException;

    T findById(Long id) throws ServiceException;

    void save(T entity) throws ServiceException;

    void delete(Long id) throws ServiceException;
}
