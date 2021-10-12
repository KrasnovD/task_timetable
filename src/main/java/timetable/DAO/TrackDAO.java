package timetable.DAO;

import timetable.entity.TrackEntity;

import java.sql.SQLException;
import java.util.List;

public interface TrackDAO extends Dao<TrackEntity> {
    String lastStation(long id) throws DaoException, SQLException;
    String firstStation(long id) throws DaoException, SQLException;
    String showType(long id) throws DaoException;
    long tickets(long id) throws DaoException;
    List<TrackEntity> TrackByStation (String stationName) throws DaoException;
}
