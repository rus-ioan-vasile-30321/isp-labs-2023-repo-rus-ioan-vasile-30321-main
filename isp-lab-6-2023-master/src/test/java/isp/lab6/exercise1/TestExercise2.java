package isp.lab6.exercise1;

import isp.lab6.exercise2.Car;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class TestExercise2 {
    @Test
    public void addVehicleTest(){
        Set<Car> data= new HashSet<Car>(){};
        Car car=new Car();
        car.setVIN("123");car.setLicense_plate("MM09FJT");
        car.setMake("Volkswagen");car.setModel("Passat");car.setYear("2006");
        data.add(car);
        Boolean actual=true;
        Boolean expected=data.contains(car);
        assertEquals(expected,actual);
    }
    @Test
    public void removeVehicleTest(){
        Set<Car> data= new HashSet<Car>(){};
        Car car=new Car();
        car.setVIN("123");car.setLicense_plate("MM09FJT");
        car.setMake("Volkswagen");car.setModel("Passat");car.setYear("2006");
        data.add(car);
        data.remove(car);
        Boolean actual=false;
        Boolean expected=data.contains(car);
        assertEquals(actual,expected);
    }
    @Test
    public void checkVehicleTest(){
        Set<Car> data= new HashSet<Car>(){};
        Car car=new Car();
        car.setVIN("123");car.setLicense_plate("MM09FJT");
        car.setMake("Volkswagen");car.setModel("Passat");car.setYear("2006");
        data.add(car);
        String actual="Car{VIN='123', license_plate='MM09FJT', make='Volkswagen', model='Passat', year='2006'}";
        String expected = null;
        for(Object i:data)
            if(i.equals(car)) expected=i.toString();
        assertEquals(expected,actual);
    }

}
