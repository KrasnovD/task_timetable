package timetable.DAO;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import timetable.projections.StationProjection;
import timetable.entity.RouteEntity;

import java.util.List;
@Repository
public interface RouteDAO extends DAO<RouteEntity, Long> {
    @Query(value = "SELECT \n" +
            "stations.name as name, routes_stations.time as time\n" +
            "FROM tracks \n" +
            "INNER JOIN routes ON tracks.routes_id = routes.id\n" +
            "INNER JOIN routes_stations ON routes.id = routes_stations.routes_id\n" +
            "INNER JOIN stations ON stations.id = routes_stations.stations_id\n" +
            "WHERE tracks.id =:id\n" +
            "ORDER BY routes_stations.sequence", nativeQuery = true)
    List<StationProjection> showAllStations(@Param("id") long id);
    @Query("SELECT r FROM route r")
    List<RouteEntity> findAll();
}
