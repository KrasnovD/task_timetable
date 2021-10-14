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
    @Column
    private long routes_id;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public long getRoutes_id() {
        return routes_id;
    }

    public void setRoutes_id(long routes_id) {
        this.routes_id = routes_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
