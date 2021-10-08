package timetable.entity;

public class TrackEntity extends Entity{
    private int type;
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
}
