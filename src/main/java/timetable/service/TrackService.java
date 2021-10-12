package timetable.service;

import timetable.DAO.DaoException;
import timetable.classes.Route;
import timetable.entity.StationEntity;
import timetable.entity.TrackEntity;

import java.sql.SQLException;
import java.util.List;

public interface TrackService extends Service<TrackEntity> {
    List<Route> showAllroutes() throws ServiceException;
    String showFirstStation(long id) throws ServiceException, SQLException, DaoException;
    String showLastStation(long id) throws ServiceException, SQLException, DaoException;
    String showType(long id) throws ServiceException, DaoException;
    List<Route> showRouteByStation(String name) throws ServiceException;
}
