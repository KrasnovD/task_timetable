package timetable.DAO;

import org.springframework.stereotype.Repository;
import timetable.entity.TrackEntity;

import java.sql.SQLException;
import java.util.List;
@Repository
public interface TrackDAO extends Dao<TrackEntity> {
    String lastStation(long id);
    String firstStation(long id) throws SQLException;
    String showType(long id);
    long tickets(long id);
    List<TrackEntity> TrackByStation (String stationName);
}
