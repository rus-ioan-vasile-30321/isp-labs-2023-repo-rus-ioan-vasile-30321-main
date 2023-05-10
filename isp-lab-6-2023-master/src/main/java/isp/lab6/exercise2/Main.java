package isp.lab6.exercise2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        char answer;
        String line;
        Set<Car> data= new HashSet<Car>(){};

        BufferedReader fluxIn = new BufferedReader(new InputStreamReader(System.in));
        do{
            System.out.println("Menu");
            System.out.println("1-Add a vehicle to the registry");
            System.out.println("2-Remove a vehicle from the registry using the VIN");
            System.out.println("3-Check if a vehicle with a given VIN is in the registry");
            System.out.println("4-Display the list of vehicles in the registry");
            System.out.println("e-exit");

            line=fluxIn.readLine();
            answer=line.charAt(0);

            switch (answer) {
                case '1':
                    Car read_car = new Car();
                    System.out.print("VIN: ");
                    read_car.setVIN(fluxIn.readLine());
                    if (data.contains(read_car)){
                        System.out.println("The car VIN is already in the database!");
                        break;
                        }
                    System.out.print("LicensePlate: ");
                    read_car.setLicense_plate(fluxIn.readLine());
                    System.out.print("Make: ");
                    read_car.setMake(fluxIn.readLine());
                    System.out.print("Model: ");
                    read_car.setModel(fluxIn.readLine());
                    System.out.print("Year: ");
                    read_car.setYear(fluxIn.readLine());
                    data.add(read_car);
                    System.out.println("Car added in the database!");
                    break;
                case '2':
                    read_car = new Car();
                    System.out.print("VIN: ");
                    read_car.setVIN(fluxIn.readLine());
                    if (!data.contains(read_car)){
                        System.out.println("The car VIN is not in the database!");
                        break;
                    }
                    data.remove(read_car);
                    System.out.println("The car with VIN-"+read_car.getVIN()+" was removed!");
                    break;
                case '3':
                    read_car = new Car();
                    System.out.print("VIN: ");
                    read_car.setVIN(fluxIn.readLine());
                    if(!data.contains(read_car)){
                        System.out.println("Don't find this VIN in the database1");
                        break;
                    }
                    for(Object i:data)
                       if(i.equals(read_car)) System.out.println(i);
                    break;
                case '4':
                    for(Object i:data)
                        System.out.println(i);
                    break;
                default:
                    System.out.println("Incorrect input!");
            }


        }while (answer!='e' && answer!='E');
        System.out.println("Program Finish!");
    }
}
