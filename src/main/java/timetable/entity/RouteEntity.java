package timetable.entity;

import org.hibernate.annotations.*;
import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Time;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "route")
@Table(name = "routes")
public class RouteEntity implements Serializable {
    @Id
    private long id;
    @Column
    private Time time;
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "routes_stations",
            joinColumns = { @JoinColumn(name = "routes_id") },
            inverseJoinColumns = { @JoinColumn(name = "stations_id") }
    )
    Set<StationEntity> station = new HashSet<>();
    @OneToMany(mappedBy="route")
    private Set<TrackEntity> trackEntities;

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
