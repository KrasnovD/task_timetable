package timetable.DAOImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

abstract public class DAOImpl {
    private Connection connection; //Создаём подключение к бд;

    protected DAOImpl() throws SQLException {
    }

    protected Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
