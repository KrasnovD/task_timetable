package timetable.DAOImpl;

import timetable.DAO.DaoException;
import timetable.DAO.StationDAO;
import timetable.classes.Station;
import timetable.entity.StationEntity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StationDAOImpl extends DAOImpl implements StationDAO {

    @Override
    public Long save(StationEntity station) throws DaoException {
        String sql = "INSERT INTO stations(name) VALUES (?)";
        ResultSet resultSet = null;
        try (PreparedStatement statement = getConnection().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, station.getName());
            statement.executeUpdate();
            resultSet = statement.getGeneratedKeys();
            resultSet.next();
            Long id = resultSet.getLong(1);
            station.setId(id);
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
    public StationEntity findById(Long id) throws DaoException {
        String sql = "SELECT stations.name FROM stations WHERE id = ?";
        ResultSet resultSet = null;
        try (PreparedStatement statement = getConnection().prepareStatement(sql)) {
            statement.setLong(1, id);
            resultSet = statement.executeQuery();
            StationEntity station = null;
            if (resultSet.next()) {
                station = new StationEntity();
                station.setId(id);
                station.setName(resultSet.getString("name"));
            }
            return station;
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
    public void update(StationEntity station) throws DaoException {
        String sql = "UPDATE stations SET name = ? WHERE id = ?";
        try (PreparedStatement statement = getConnection().prepareStatement(sql)) {
            statement.setString(1, station.getName());
            statement.setLong(2, station.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void delete(Long id) throws DaoException {
        String sql = "DELETE FROM stations WHERE id = ?";
        PreparedStatement statement = null;
        try {
            statement = getConnection().prepareStatement(sql);
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch(SQLException e) {
            throw new DaoException(e);
        } finally {
            try {
                assert statement != null;
                statement.close();
            } catch(Exception ignored) {}
        }
    }

    @Override
    public List<StationEntity> readAll() throws DaoException {
        String sql = "SELECT id, name FROM stations";
        try (PreparedStatement statement = getConnection().prepareStatement(sql); ResultSet resultSet = statement.executeQuery()) {
            List<StationEntity> stationEntities = new ArrayList<>();
            while (resultSet.next()) {
                StationEntity stationEntity = new StationEntity();
                stationEntity.setId(resultSet.getLong("id"));
                stationEntity.setName(resultSet.getString("name"));
                stationEntities.add(stationEntity);
            }
            return stationEntities;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }
}
