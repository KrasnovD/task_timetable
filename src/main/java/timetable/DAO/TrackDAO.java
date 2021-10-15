package timetable.DAO;

import org.springframework.stereotype.Repository;
import timetable.entity.TrackEntity;

import java.util.List;

@Repository
public interface TrackDAO extends DAO<TrackEntity>{
    String lastStation(long id)  ;
    String firstStation(long id)  ;
    String showType(long id)  ;
    List<TrackEntity> TrackByStation (String stationName);
}
