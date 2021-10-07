package timetable.entity;


import javax.persistence.*;
import java.util.Collection;

//@Entity
//@Table(name = "stations")
public class StationEntity extends Entity {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;

//    @Column(nullable = false)
    private String name;

//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
