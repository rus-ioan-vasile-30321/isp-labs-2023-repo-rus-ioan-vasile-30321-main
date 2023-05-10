package isp.lab8.airways;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class  fileWork {
    public static boolean checkRouteExist(String routeName){
        File[] allroutes=new File("src/main/java/isp/lab8/airways/routes").listFiles();
        for(File i:allroutes)
            if(i.getName().equals(routeName))return true;
        return false;
    }
    public static ArrayList<String> getWaypointsName(String routeName){
        ArrayList<String> waypointsNames=new ArrayList<>();
        File[] all=new File("src/main/java/isp/lab8/airways/routes/"+routeName).listFiles();
        for(File i:all) {
            waypointsNames.add(i.getName());
        }
        return waypointsNames;
    }
    public static Set<Waypoint> convertToWaypoint(ArrayList<String> waypointsName,String routename){
        Set<Waypoint> waypointSet=new TreeSet<>(new indexComparator());
        for(String i:waypointsName) {
            try {

                Gson gson=new Gson();
                Waypoint waypoint=gson.fromJson(new FileReader("D:\\Facultate Utcn\\AN2\\SemII\\Software Engenering\\Repository\\isp-labs-2023-repo-rus-ioan-vasile-30321\\isp-lab-8-2023-main\\src\\main\\java\\isp\\lab8\\airways\\routes\\"+routename+"\\"+i),Waypoint.class);
                waypointSet.add(waypoint);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

        return waypointSet;
    }


}
