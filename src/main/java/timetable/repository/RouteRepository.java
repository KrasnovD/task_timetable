package timetable.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import timetable.entity.Route;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Repository
public interface RouteRepository extends JpaRepository<Route, Long> {
    @Query(value = "SELECT routes_stations.time, stations.name FROM tracks INNER JOIN routes ON tracks.routes_id = routes.id INNER JOIN routes_stations ON routes.id = routes_stations.routes_id INNER JOIN stations ON stations.id = routes_stations.stations_id WHERE tracks.id = ?1 ORDER BY routes_stations.sequence", nativeQuery = true)
    List<String> showAllRoute(Long id);
    @Query(value = "SELECT stations.name FROM tracks INNER JOIN routes ON tracks.routes_id = routes.id INNER JOIN routes_stations ON routes.id = routes_stations.routes_id INNER JOIN stations ON stations.id = routes_stations.stations_id WHERE routes.id = ?1 ORDER BY routes_stations.sequence ASC LIMIT 1", nativeQuery = true)
    String showFirstStation(Long id);
    @Query(value = "SELECT stations.name FROM tracks INNER JOIN routes ON tracks.routes_id = routes.id INNER JOIN routes_stations ON routes.id = routes_stations.routes_id INNER JOIN stations ON stations.id = routes_stations.stations_id WHERE routes.id = ?1 ORDER BY routes_stations.sequence DESC LIMIT 1", nativeQuery = true)
    String showLastStation(Long id);
    @Query(value = "SELECT tracks.type FROM tracks INNER JOIN routes ON tracks.routes_id = routes.id WHERE routes.id = ?1", nativeQuery = true)
    Integer showType(Long id);
    @Query(value = "SELECT routes.id FROM routes", nativeQuery = true)
    Collection<Long> allIdRoutes();
    @Query(value = "SELECT tracks.id FROM tracks INNER JOIN routes ON tracks.routes_id = routes.id WHERE routes.id = ?1", nativeQuery = true)
    Long trackid(Long id);
}
