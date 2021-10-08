package timetable;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import timetable.DAOImpl.DAOImpl;

import java.sql.DriverManager;
import java.sql.SQLException;

@SpringBootApplication
public class Application {
    public static void main(String[] args) throws SQLException {
        DAOImpl.setConnection(DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","root"));
        SpringApplication.run(Application.class, args);

    }
}
