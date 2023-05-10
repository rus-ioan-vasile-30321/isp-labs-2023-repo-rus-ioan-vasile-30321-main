package isp.lab8.airways;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

/**
 * Example waypoint class which can be extended to be used in implementation of the exercise. Add constructor, getters, setters, etc.
 */
public class Waypoint {
    private int index;
    private String name;
    private double latitude;
    private double longitude;
    private int altitude;

    public Waypoint(int index, String name, double latitude, double longitude, int altitude) {
        this.index = index;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.altitude = altitude;
    }

    public Waypoint() {
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Waypoint waypoint = (Waypoint) o;
        return index == waypoint.index && Double.compare(waypoint.latitude, latitude) == 0 && Double.compare(waypoint.longitude, longitude) == 0 && altitude == waypoint.altitude;
    }
    public String getName() {
        return name;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    @Override
    public int hashCode() {
        return Objects.hash(index, latitude, longitude, altitude);
    }

    @Override
    public String toString() {
        return "\n{" +
                "index=" + index +
                ", name='" + name + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", altitude=" + altitude +
                '}';
    }
    public void modify() throws IOException {
        BufferedReader fluxIn = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Tap \'yes\' if you want to modify something.");
        String input;
        System.out.println("Modify the name: ");input=fluxIn.readLine();
        if(input.equals("yes")){
            System.out.println("NEW name: ");
            this.name=fluxIn.readLine();
            input="";
        }

        System.out.println("Modify the latitude: ");input=fluxIn.readLine();
        if(input.equals("yes")){
            System.out.println("NEW latitude: ");
            this.latitude= Double.parseDouble(fluxIn.readLine());
            input="";
        }


        System.out.println("Modify the longitude: ");input=fluxIn.readLine();
        if(input.equals("yes")){
            System.out.println("NEW longitude: ");
            this.longitude= Double.parseDouble(fluxIn.readLine());
            input="";
        }


        System.out.println("Modify the altitude: ");input=fluxIn.readLine();
        if(input.equals("yes")){
            System.out.println("NEW altitude: ");
            this.altitude= Integer.parseInt(fluxIn.readLine());
            input="";
        }

    }
}
