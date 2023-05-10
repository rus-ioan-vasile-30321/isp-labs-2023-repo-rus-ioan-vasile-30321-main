package isp.lab8.airways;

import com.google.gson.Gson;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import static isp.lab8.airways.fileWork.*;
import static isp.lab8.airways.WaypointDistanceCalculator.*;

public class Main {
    public static void main(String[] args) throws IOException {
        char answer;
        String line;
        BufferedReader fluxIn = new BufferedReader(new InputStreamReader(System.in));
        do{
            System.out.println("****************");
            System.out.println("Menu:          *");

            /*
            ->name_of_the_route
            ->check if(name_of...) is available
            ->create a folder with this name
            ->end process
            Create a route: create a folder
             */
            System.out.println("1-Create Route *");
             /*
            ->name_of_the_route
            ->check if(name_of...) is available
            ->delete the folder with this name
            ->end process
            Create a route: create a folder
             */
            System.out.println("2-Delete Route *");
             /**
            ->name_of_the_route
            ->check if(name_of...) is available
              @addWaypoint
              ->introduce the data for a waypoint
              ->check if the waypoint is unique for that route
              ->save the waypoint
              @removeWaypoint
              ->list the waypoints for that route
              ->delete the waypoint using the index
              ->reallocate the indexes for that route if needed
              ->delete file
             **/
            System.out.println("3-Modify Route *");
            /**
             *1-Display all routes
             * Load is made automatically after the name of the route
             * 2-Distance of the route
             * 3-List of waypoints
             */
            System.out.println("4-View options *");
            System.out.println("e-exit         *");

            line=fluxIn.readLine();
            answer=line.charAt(0);

            switch (answer){
                case '1':
                    loadCreateRoute();
                    break;
                case '2':
                    System.out.print("Route name: ");
                    String routename=fluxIn.readLine();
                    if(Files.deleteIfExists(Path.of("src/main/java/isp/lab8/airways/routes/" + routename)))
                        try{
                        Files.delete(Path.of("src/main/java/isp/lab8/airways/routes/" + routename));}
                        catch (NoSuchFileException e){
                        }
                    else System.out.println("Name could be wrong!");
                    break;
                case '3':
                    System.out.print("Route name: ");
                    routename=fluxIn.readLine();
                    if(checkRouteExist(routename)){
                        loadModifyWaypoint(routename);
                    }
                    else System.out.println("Name could be wrong!");
                    break;
                case '4':
                    loadViewOptions();
                    break;
                default:
                    System.out.println("Incorrect input!");
            }


        }while (answer!='e' && answer!='E');
        System.out.println("Program Finish!");
    }

    public static void loadViewOptions() throws IOException {
        char answer;
        String line;
        BufferedReader fluxIn = new BufferedReader(new InputStreamReader(System.in));

        Route route=new Route();
        boolean  loaded=false;

        do{
            System.out.println("-----------------------");
            System.out.println("View options:         |");
            System.out.println("1-Display all routes  |");
            System.out.println("2-Load route          |");
            System.out.println("3-Distance of a route |");
            System.out.println("4-Waypoints of a route|");
            System.out.println("e-exit                |");

            line=fluxIn.readLine();
            answer=line.charAt(0);

            switch (answer){
                case '1':
                    File[] allroutes=new File("src/main/java/isp/lab8/airways/routes").listFiles();
                    for(File i:allroutes)
                        System.out.println("->"+i.getName());
                    break;
                case '2':
                    System.out.println("Your route name: ");
                    String routeName=fluxIn.readLine();
                    if(checkRouteExist(routeName)){
                        route.setName(routeName);
                        Set<Waypoint> waypointSet=new TreeSet<>();
                        waypointSet=convertToWaypoint(getWaypointsName(routeName),routeName);
                        route.setWaypoints(waypointSet);
                        loaded=true;
                    }
                    else System.out.println("The route is not exist!");
                    break;
                case '3':
                    if(loaded) {
                        double distance=0;
                        Waypoint prev=null;
                        for (Waypoint i:route.getWaypoints()){
                            if (prev != null) {
                                distance += calculateDistance(prev.getLatitude(), prev.getLongitude(), i.getLatitude(), i.getLongitude());

                            }
                            prev = i;
                        }
                        System.out.println("The distance is of: "+distance+" km");
                    }
                    else System.out.println("The route is not loaded.");
                    break;
                case '4':
                    if(loaded) {
                        for(Waypoint i:route.getWaypoints()) {
                            System.out.print("|" + i.getName() + "| " );
                        }
                        System.out.println("");
                    }
                    else System.out.println("The route is not loaded.");
                    break;
                default:
                    System.out.println("Incorrect input!");
            }


        }while (answer!='e' && answer!='E');
    }

    public static void loadCreateRoute() throws IOException {
        char answer;
        String line;
        BufferedReader fluxIn = new BufferedReader(new InputStreamReader(System.in));

        Route route=new Route();
        Set<Waypoint> waypoints=new TreeSet<>(new indexComparator());
        boolean route_name_pick=false;

        do{

            System.out.println("---------------");
            System.out.println("Create Route:    |");
            System.out.println("1-Route name     |");
            System.out.println("2-Add Waypoint   |");
            System.out.println("3-Visualize route|");
            System.out.println("4-Save Route     |");
            System.out.println("e-exit           |");

            line=fluxIn.readLine();
            answer=line.charAt(0);
            switch (answer){
                case '1':
                    System.out.print("Name: ");
                    String name=fluxIn.readLine();
                    if(!checkRouteExist(name)){
                        route.setName(name);
                        route_name_pick=true;
                    }
                    else System.out.println("Route name already exist!");
                    break;
                case '2':
                    System.out.print("   index: ");
                    int index= Integer.parseInt(fluxIn.readLine());
                    System.out.print("    name: ");
                    name=fluxIn.readLine();
                    System.out.print("latitude: ");
                    double lat= Double.parseDouble(fluxIn.readLine());
                    System.out.print("longitude: ");
                    double log=Double.parseDouble(fluxIn.readLine());
                    System.out.print(" altitude: ");
                    int alt=Integer.parseInt(fluxIn.readLine());
                    Waypoint waypoint=new Waypoint(index,name,lat,log,alt);
                    if(waypoints.add(waypoint)) {
                        route.setWaypoints(waypoints);
                        System.out.println("Successfully added!");
                    }
                    else System.out.println("Check index,latitude,longitude,altitude!");
                    fluxIn.readLine();
                    break;
                case '3':
                    System.out.println( route.toString());
                    break;
                case '4':
                    if(route_name_pick){
                        Files.createDirectories(Paths.get("src/main/java/isp/lab8/airways/routes/"+route.getName()));
                        Gson gson = new Gson();
                        //IMPLEMENTEAZA PENTRU TOATA LISTA
                        for(Waypoint i:route.getWaypoints()){
                            String json = gson.toJson(i);
                            try (Writer writer = new FileWriter("src/main/java/isp/lab8/airways/routes/"+route.getName()+"/"+i.getName().substring(0,i.getName().indexOf("("))+".json")) {
                                writer.write(json);
                            }
                        }
                    }
                    else System.out.println("Pick a name for route!");
                    break;
                default:
                    System.out.println("Incorrect input!");
            }


        }while (answer!='e' && answer!='E');
    }

    public static void loadModifyWaypoint(String route_name) throws IOException {
        char answer;
        String line;
        BufferedReader fluxIn = new BufferedReader(new InputStreamReader(System.in));

        //load the route with all waypoints
        Route route=new Route();
        route.setName(route_name);
        Set<Waypoint> waypointSet=new TreeSet<>(new indexComparator());
        waypointSet=convertToWaypoint(getWaypointsName(route_name),route_name);
        route.setWaypoints(waypointSet);


        do{
            System.out.println("-----------------------");
            System.out.println("Modify Option:         |");
            System.out.println("1-Display all Waypoints|");
            System.out.println("2-Modify Waypoint      |");
            System.out.println("3-Delete Waypoint      |");
            System.out.println("4-Add Waypoint         |");
            System.out.println("e-exit                 |");


            line=fluxIn.readLine();
            answer=line.charAt(0);

            switch (answer){
                case '1':
                    for(Waypoint i:route.getWaypoints()) {
                        System.out.print("|" + i.getName() + "| " );
                    }
                    System.out.println("");
                    break;
                case '2':
                    System.out.println("Index of the Waypoint: ");
                    int index_waipoint= Integer.parseInt(fluxIn.readLine());
                    for(Waypoint i:route.getWaypoints()) {
                        if(i.getIndex()==index_waipoint)i.modify();
                    }
                    break;
                case '3':
                    System.out.println("Index of the Waypoint: ");
                    index_waipoint= Integer.parseInt(fluxIn.readLine());
                    Waypoint waypoint = null;
                    for(Waypoint i:route.getWaypoints()) {
                        if(i.getIndex()==index_waipoint)waypoint=i;
                        if(waypoint!=null)i.setIndex(i.getIndex()+1);
                    }
                    route.deleteWaypoint(waypoint);
                    break;
                case '4':
                    System.out.print("   index: ");
                    int index= Integer.parseInt(fluxIn.readLine());
                    System.out.print("    name: ");
                    String name=fluxIn.readLine();
                    System.out.print("latitude: ");
                    double lat= Double.parseDouble(fluxIn.readLine());
                    System.out.print("longitude: ");
                    double log=Double.parseDouble(fluxIn.readLine());
                    System.out.print(" altitude: ");
                    int alt=Integer.parseInt(fluxIn.readLine());
                    waypoint=new Waypoint(index,name,lat,log,alt);
                    Set<Waypoint> waypoints=route.getWaypoints();
                    if(waypoints.add(waypoint)) {
                        route.setWaypoints(waypoints);
                        System.out.println("Successfully added!");
                    }
                    else System.out.println("Check index,latitude,longitude,altitude!");
                    fluxIn.readLine();
                    break;
                default:
                    System.out.println("Incorrect input!");
            }


        }while (answer!='e' && answer!='E');

        //save file
        Files.createDirectories(Paths.get("src/main/java/isp/lab8/airways/routes/"+route.getName()));
        Gson gson = new Gson();
        //IMPLEMENTEAZA PENTRU TOATA LISTA
        for(Waypoint i:route.getWaypoints()){
            String json = gson.toJson(i);
            try (Writer writer = new FileWriter("src/main/java/isp/lab8/airways/routes/"+route.getName()+"/"+i.getName().substring(0,i.getName().indexOf("("))+".json")) {
                writer.write(json);
            }
        }

    }
}

