package isp.lab8.airways;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Route {

    private Set<Waypoint> waypoints;
    private String name;

    public Route() {
        this.waypoints=new TreeSet<>(new indexComparator());
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWaypoints(Set<Waypoint> waypoints) {
        this.waypoints = waypoints;
    }

    public Set<Waypoint> getWaypoints() {
        return waypoints;
    }

    public String getName() {
        return name;
    }

    public void deleteWaypoint( Waypoint waypoint){
        this.waypoints.remove(waypoint);
    }
    @Override
    public String toString() {
        return "Route: " +
                " name= '" + name + '\'' +
                waypoints

                ;
    }
}
