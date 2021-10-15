package timetable.entity;


import org.hibernate.annotations.Columns;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "station")
@Table(name = "stations")
public class StationEntity implements Serializable {
    @Id
    private long id;
    @Column
    private String name;
    @ManyToMany(mappedBy = "station")
    private Set<RouteEntity> routes = new HashSet<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
