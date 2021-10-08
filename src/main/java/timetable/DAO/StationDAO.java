package timetable.DAO;

import timetable.entity.StationEntity;

import java.util.List;

public interface StationDAO extends Dao<StationEntity> {
    List<String> showAllStations(long id) throws DaoException;
}
