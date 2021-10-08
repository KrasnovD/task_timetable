package timetable.DAOImpl;

import java.sql.Connection;


abstract public class DAOImpl {
    private static Connection connection;
    protected Connection getConnection() {
        return connection;
    }

    public static void setConnection(Connection tempConnection) {
        connection = tempConnection;
    }
}
