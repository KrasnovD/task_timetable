package timetable.entity;

import java.sql.Time;

public class RouteEntity extends Entity {
    private Time time;

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }
}
