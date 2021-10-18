package timetable.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import timetable.entity.TrackEntity;

import java.util.List;

@Repository
public interface TrackDAO extends DAO<TrackEntity, Long> {
    @Query(value = "SELECT stations.name\n" +
            "FROM tracks\n" +
            "INNER JOIN routes ON tracks.routes_id = routes.id\n" +
            "INNER JOIN routes_stations ON routes.id = routes_stations.routes_id\n" +
            "INNER JOIN stations ON stations.id = routes_stations.stations_id\n" +
            "WHERE tracks.id = :id ORDER BY routes_stations.sequence DESC LIMIT 1", nativeQuery = true)
    String lastStation(@Param("id") long id)  ;
    @Query(value = "SELECT stations.name\n" +
            "FROM tracks\n" +
            "INNER JOIN routes ON tracks.routes_id = routes.id\n" +
            "INNER JOIN routes_stations ON routes.id = routes_stations.routes_id\n" +
            "INNER JOIN stations ON stations.id = routes_stations.stations_id\n" +
            "WHERE tracks.id = :id ORDER BY routes_stations.sequence ASC LIMIT 1", nativeQuery = true)
    String firstStation(@Param("id") long id);
    @Query("select t.type from track t where t.id = :id ")
    int showType(@Param("id") long id);
    @Query("SELECT t FROM track t INNER JOIN t.route.station s WHERE s.name LIKE :name")
    List<TrackEntity> TrackByStation (@Param("name") String stationName);
    @Query("SELECT t FROM track t")
    List<TrackEntity> findAll();
}
