package timetable.entity;

import org.hibernate.annotations.*;

import javax.persistence.Column;
import java.sql.Time;

@org.hibernate.annotations.Entity
@Table(appliesTo = "routes")
public class RouteEntity extends Entity {
    @Column
    private Time time;

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }
}
