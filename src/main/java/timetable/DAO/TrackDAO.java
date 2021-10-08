package timetable.DAO;

import timetable.entity.TrackEntity;

import java.sql.SQLException;

public interface TrackDAO extends Dao<TrackEntity> {
    String lastStation(long id) throws DaoException, SQLException;
    String firstStation(long id) throws DaoException, SQLException;
    String showType(long id) throws DaoException;
}
