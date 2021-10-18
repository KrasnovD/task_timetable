package timetable.classes;

import org.springframework.beans.factory.annotation.Value;

import java.sql.Time;

public class Station {
    private String name;
    private Time time;

    public Station(String name, Time time) {
        this.name = name;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

}
