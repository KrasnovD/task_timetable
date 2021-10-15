package timetable.entity;


import javax.persistence.*;

import javax.persistence.TableGenerator;
import java.io.Serializable;

@Entity(name = "track")
@Table(name = "tracks")
public class TrackEntity implements Serializable {
    @Id
    private long id;
    @Column
    private int type;

    @ManyToOne
    @JoinColumn(name = "routes_id")
    private RouteEntity route;

    public RouteEntity getRoute() {
        return route;
    }

    public void setRoute(RouteEntity route) {
        this.route = route;
    }


    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
