package timetable.DAOImpl;

import timetable.DAO.RouteDAO;
import timetable.classes.Station;
import timetable.entity.RouteEntity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RouteDAOImpl extends DAOImpl implements RouteDAO {
    @Override
    public Long save(RouteEntity routeEntity){
        String sql = "INSERT INTO routes(time) VALUES (?)";
        ResultSet resultSet = null;
        try (PreparedStatement statement = getConnection().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            statement.setTime(1, routeEntity.getTime());
            statement.executeUpdate();
            resultSet = statement.getGeneratedKeys();
            resultSet.next();
            Long id = resultSet.getLong(1);
            routeEntity.setId(id);
            return id;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public RouteEntity findById(Long id){
        String sql = "SELECT routes.time FROM routes WHERE id = ?";
        ResultSet resultSet = null;
        try (PreparedStatement statement = getConnection().prepareStatement(sql)) {
            statement.setLong(1, id);
            resultSet = statement.executeQuery();
            RouteEntity routeEntity = null;
            if (resultSet.next()) {
                routeEntity = new RouteEntity();
                routeEntity.setId(id);
                routeEntity.setTime(resultSet.getTime("time"));
            }
            return routeEntity;
        } catch (SQLException e) {
            e.printStackTrace();
            return new RouteEntity();
        }
    }

    @Override
    public void update(RouteEntity routeEntity){
        String sql = "UPDATE routes SET time = ? WHERE id = ?";
        try (PreparedStatement statement = getConnection().prepareStatement(sql)) {
            statement.setTime(1, routeEntity.getTime());
            statement.setLong(2, routeEntity.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Long id){
        String sql = "DELETE FROM routes WHERE id = ?";
        PreparedStatement statement = null;
        try {
            statement = getConnection().prepareStatement(sql);
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<RouteEntity> readAll(){
        String sql = "SELECT id, time FROM routes";
        try (PreparedStatement statement = getConnection().prepareStatement(sql); ResultSet resultSet = statement.executeQuery()) {
            List<RouteEntity> routeEntities = new ArrayList<>();
            while (resultSet.next()) {
                RouteEntity routeEntity = new RouteEntity();
                routeEntity.setId(resultSet.getLong("id"));
                routeEntity.setTime(resultSet.getTime("time"));
                routeEntities.add(routeEntity);
            }
            return routeEntities;
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public List<Station> showAllStations(long id){
        String sql = "SELECT routes_stations.time, stations.name FROM tracks " +
                "INNER JOIN routes ON tracks.routes_id = routes.id " +
                "INNER JOIN routes_stations ON routes.id = routes_stations.routes_id " +
                "INNER JOIN stations ON stations.id = routes_stations.stations_id " +
                "WHERE tracks.id = ? ORDER BY routes_stations.sequence ";
        try{
            PreparedStatement statement = getConnection().prepareStatement(sql);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            List<Station> allStations = new ArrayList<>();
            while (resultSet.next()) {
                Station station = new Station();
                station.setTime(resultSet.getTime("time"));
                station.setName(resultSet.getString("name"));
                System.out.println(station.getName() + " " + station.getTime());
                allStations.add(station);
            }
            return allStations;
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
