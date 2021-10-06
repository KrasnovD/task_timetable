package timetable.entity;


import javax.persistence.*;
import java.sql.Time;
import java.util.Collection;

@Entity
@Table(name = "routes")
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Time time;
    @ManyToMany(fetch = FetchType.LAZY)
    private Collection<Station> stations;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }
}
