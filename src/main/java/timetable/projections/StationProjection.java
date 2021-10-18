package timetable.projections;

import java.sql.Time;

public interface StationProjection {
    String getName();

    Time getTime();
}
