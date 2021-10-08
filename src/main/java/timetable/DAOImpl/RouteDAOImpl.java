package timetable.DAOImpl;

import timetable.DAO.DaoException;
import timetable.DAO.RouteDAO;
import timetable.entity.RouteEntity;
import timetable.entity.StationEntity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RouteDAOImpl extends DAOImpl implements RouteDAO {
    @Override
    public Long save(RouteEntity routeEntity) throws DaoException {
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
            throw new DaoException(e);
        } finally {
            try {
                assert resultSet != null;
                resultSet.close();
            } catch (Exception ignored) {
            }
        }
    }

    @Override
    public RouteEntity findById(Long id) throws DaoException {
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
            throw new DaoException(e);
        } finally {
            try {
                assert resultSet != null;
                resultSet.close();
            } catch (Exception ignored) {
            }
        }
    }

    @Override
    public void update(RouteEntity routeEntity) throws DaoException {
        String sql = "UPDATE routes SET time = ? WHERE id = ?";
        try (PreparedStatement statement = getConnection().prepareStatement(sql)) {
            statement.setTime(1, routeEntity.getTime());
            statement.setLong(2, routeEntity.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void delete(Long id) throws DaoException {
        String sql = "DELETE FROM routes WHERE id = ?";
        PreparedStatement statement = null;
        try {
            statement = getConnection().prepareStatement(sql);
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            try {
                assert statement != null;
                statement.close();
            } catch (Exception ignored) {
            }
        }
    }

    @Override
    public List<RouteEntity> readAll() throws DaoException {
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
            throw new DaoException(e);
        }
    }

    @Override
    public List<String> showAllStations() throws DaoException {
        String sql = "SELECT routes_stations.time, stations.name FROM tracks INNER JOIN routes ON tracks.routes_id = routes.id INNER JOIN routes_stations ON routes.id = routes_stations.routes_id INNER JOIN stations ON stations.id = routes_stations.stations_id WHERE tracks.id = ?1\n";
        try (PreparedStatement statement = getConnection().prepareStatement(sql); ResultSet resultSet = statement.executeQuery()) {
            List<String> allStations = new ArrayList<>();
            while (resultSet.next()) {
                String station = null;
                station += resultSet.getTime("routes_stations.time") + " — ";
                station += resultSet.getString("stations.name") + "\n";
                allStations.add(station);
            }
            return allStations;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }
}
