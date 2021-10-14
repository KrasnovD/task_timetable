package timetable.DAO;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import timetable.classes.Track;
import timetable.entity.TrackEntity;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
@Repository
public interface TrackDAO extends DAO<TrackEntity>{
    String lastStation(long id);
    String firstStation(long id) throws SQLException;
    String showType(long id);
    List<TrackEntity> TrackByStation (String stationName);
    @Query("SELECT t FROM track t")
    Collection findAll();
    List<Long> findAllId();
}
