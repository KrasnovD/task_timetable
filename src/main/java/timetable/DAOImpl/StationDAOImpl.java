package timetable.DAOImpl;

import timetable.DAO.RouteDAO;
import timetable.DAO.StationDAO;
import timetable.classes.Station;
import timetable.entity.RouteEntity;
import timetable.entity.StationEntity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StationDAOImpl implements StationDAO {
    @Override
    public List<StationEntity> findAll() {
        return null;
    }
}
