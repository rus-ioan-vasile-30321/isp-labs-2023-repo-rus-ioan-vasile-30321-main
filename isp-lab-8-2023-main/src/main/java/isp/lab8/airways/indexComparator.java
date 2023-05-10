package isp.lab8.airways;

import java.util.Comparator;

public class indexComparator implements Comparator<Waypoint> {

    @Override
    public int compare(Waypoint o1, Waypoint o2) {
        return o1.getIndex()-o2.getIndex();
    }


}
